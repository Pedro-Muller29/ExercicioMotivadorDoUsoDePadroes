package com.carro.motor;

import com.carro.TipoCombustivel;

class MotorComum implements Motor {

    private TipoCombustivel tipoMotor;
    private int consumo; // em quilometros por unidade. Ex: Km/Lt
    private int quilometragem;

    public MotorComum(TipoCombustivel tipoMotor, int consumo) {
        this.tipoMotor = tipoMotor;
        this.consumo = consumo;
        this.quilometragem = 0;
    }

    public int getConsumo(TipoCombustivel tipoCombustivel) throws Exception {
        if (tipoCombustivel == tipoMotor) {
            return this.consumo;
        }
        throw new Exception("Tipo de combustível não suportado");
    }

    public TipoCombustivel getTipoMotor() {
        return this.tipoMotor;
    }

    public int getQuilometragem() {
        return this.quilometragem;
    }

    public int combustivelNecessario(int distancia, TipoCombustivel tipoCombustivel) throws Exception {
        if (tipoCombustivel == tipoMotor) {
            return distancia / consumo;
        }
        throw new Exception("Tipo de Combustível não suportado");
    }

    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    @Override
    public String toString() {
        return "Motor [consumo=" + consumo + ", quilometragem=" + quilometragem + ", tipoMotor=" + tipoMotor + "]";
    }
}