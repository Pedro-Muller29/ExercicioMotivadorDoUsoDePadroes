package com.carro;

import com.carro.tanque_combustivel.FactoryTanqueCombustivel;
import com.carro.tanque_combustivel.TanqueCombustivel;

public class Carro {

    private ModeloCarro modelo;
    private Motor motor;
    private TanqueCombustivel tanque;

    Carro(ModeloCarro modelo, TipoCombustivel tipoTanqueCombustivel, TipoCombustivel tipoCombustivelMotor, int consumoMotor, int capacidadeTanque) {
        this.modelo = modelo;
        motor = new Motor(tipoCombustivelMotor, consumoMotor);
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
        int capacidadeLivre = tanque.getCapacidade() - tanque.getCombustivelDisponivel(tipoCombustivel);
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
        int combustivelNecessario = motor.combustivelNecessario(distancia);
        if (tanque.getCombustivelDisponivel(motor.getTipoMotor()) >= combustivelNecessario) {
            return distancia;
        } else {
            return tanque.getCombustivelDisponivel(motor.getTipoMotor()) * motor.getConsumo();
        }
    }

    // Retorna true se conseguiu viajar
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia), motor.getTipoMotor());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carro:\n  Modelo=" + modelo + "\n  Motor=" + motor + "\n  Tanque=" + tanque;
    }
}
