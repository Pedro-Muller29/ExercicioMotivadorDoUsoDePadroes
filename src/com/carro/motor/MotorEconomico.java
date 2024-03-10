package com.carro.motor;

import com.carro.TipoCombustivel;

public class MotorEconomico implements Motor {

    private TipoCombustivel tipoMotor;
    private int quilometragem;
    private int consumoInicial; // em quilometros por unidade. Ex: Km/Lt
    private int consumoMinimo;
    private int kmPorDecaimento;

    MotorEconomico(TipoCombustivel tipoMotor, int consumoInicial, int consumoMinimo, int kmPorDecaimento) {
        this.tipoMotor = tipoMotor;
        this.consumoInicial = consumoInicial;
        this.consumoMinimo = consumoMinimo;
        this.kmPorDecaimento = kmPorDecaimento;
        this.quilometragem = 0;
    }

    @Override
    public int getConsumo(TipoCombustivel tipoCombustivel) throws Exception {
        return (consumoInicial - (Math.min(consumoInicial - consumoMinimo, quilometragem/kmPorDecaimento)));
    }

    @Override
    public TipoCombustivel getTipoMotor() {
        return tipoMotor;
    }

    @Override
    public int getQuilometragem() {
        return quilometragem;
    }

    @Override
    public int combustivelNecessario(int distancia, TipoCombustivel tipoCombustivel) throws Exception {
        int combustivelNecessario = 0;
        int quilometragemFicticia = quilometragem;
        while (distancia > 0) {
            int kmsAteProximoDecaimento = kmPorDecaimento - (quilometragemFicticia % kmPorDecaimento);
            if (distancia <= kmsAteProximoDecaimento) {
                combustivelNecessario += distancia/(consumoInicial - (Math.min(consumoInicial - consumoMinimo, quilometragemFicticia/kmPorDecaimento)));
                distancia = 0;
            } else {
                combustivelNecessario += kmsAteProximoDecaimento/(consumoInicial - (Math.min(consumoInicial - consumoMinimo, quilometragemFicticia/kmPorDecaimento)));
                distancia -= kmsAteProximoDecaimento;
                quilometragemFicticia += kmsAteProximoDecaimento;
            }
        }
        return combustivelNecessario;
    }

    @Override
    public void percorre(int distancia) {
        quilometragem += distancia;
    }
    
    @Override
    public String toString() {
        try {
            return "Motor [consumoAtual=" + getConsumo(tipoMotor) + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
        } catch (Exception e) {
            e.printStackTrace();
            return "Motor [consumoMinimo=" + consumoMinimo + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
        }
    }
}
