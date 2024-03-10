package com.carro;

import com.carro.motor.Motor;
import com.carro.tanque_combustivel.FactoryTanqueCombustivel;
import com.carro.tanque_combustivel.TanqueCombustivel;

public class Carro {

    private ModeloCarro modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    Carro(ModeloCarro modelo, TipoCombustivel tipoTanqueCombustivel, Motor motor, int capacidadeTanque) {
        this.modelo = modelo;
        this.motor = motor;
        tanque = FactoryTanqueCombustivel.getTanque(tipoTanqueCombustivel, capacidadeTanque);
    }

    public ModeloCarro getModelo() {
        return modelo;
    }

    public int getCombustivelDisponivel(TipoCombustivel tipoCombustivel) {
        return tanque.getCombustivelDisponivel(tipoCombustivel);
    }

    // Retorna a quantidade efetivamente abastecida
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = tanque.getCapacidadeDisponivel();
        if (capacidadeLivre < quantidade) {
            tanque.abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            tanque.abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    // Retorna a distancia que consegue viajar com o combustivel remanescente
    public int verificaSePodeViajar(int distancia) {
        // Infelizmente aqui não tem jeito, tive que fazer uma checagem manual do tipo do motor
        if (motor.getTipoMotor() == TipoCombustivel.FLEX) {
            int combustivelAlcool = tanque.getCombustivelDisponivel(TipoCombustivel.ALCOOL);
            int combustivelGasolina = tanque.getCombustivelDisponivel(TipoCombustivel.GASOLINA);

            try {
                int consumoAlcool = motor.getConsumo(TipoCombustivel.ALCOOL);
                int consumoGasolina = motor.getConsumo(TipoCombustivel.GASOLINA);

                return Math.min((consumoAlcool * combustivelAlcool) + (consumoGasolina * combustivelGasolina), distancia);
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }            
        } 
        // Caso o motor não seja FLEX, o procedimento é o mesmo
        else {
            try {
                int combustivelNecessario = motor.combustivelNecessario(distancia, motor.getTipoMotor());
                if (tanque.getCombustivelDisponivel(motor.getTipoMotor()) >= combustivelNecessario) {
                    return distancia;
                } else {
                    return tanque.getCombustivelDisponivel(motor.getTipoMotor()) * motor.getConsumo(motor.getTipoMotor());
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            // Mais uma vez fui obrigado a realizar checagem manual
            if (motor.getTipoMotor() == TipoCombustivel.FLEX) {
                try {
                    int combustivelAlcool = tanque.getCombustivelDisponivel(TipoCombustivel.ALCOOL);
                    int consumoAlcool = motor.getConsumo(TipoCombustivel.ALCOOL);
                    int consumoGasolina = motor.getConsumo(TipoCombustivel.GASOLINA);
                    
                    motor.percorre(distancia);
                    if ((combustivelAlcool * consumoAlcool) >= distancia) {
                        tanque.gasta(distancia/consumoAlcool, TipoCombustivel.ALCOOL);
                        return true;
                    } else {
                        tanque.gasta(combustivelAlcool, TipoCombustivel.ALCOOL);
                        distancia -= consumoAlcool * combustivelAlcool;
                    }
                    tanque.gasta(distancia/consumoGasolina, TipoCombustivel.GASOLINA);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            } 
            // Se não for flex, segue a vida normal
            else {
                try {
                    int combustivelNecessario = motor.combustivelNecessario(distancia, motor.getTipoMotor());
                    motor.percorre(distancia);
                    tanque.gasta(combustivelNecessario, motor.getTipoMotor());
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
