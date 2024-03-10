package com.carro.motor;

import com.carro.TipoCombustivel;

class MotorFlex implements Motor {
    private int consumoAlcool;
    private int consumoGasolina;
    private int quilometragem;

    MotorFlex(int consumoAlcool, int consumoGasolina) {
        this.consumoAlcool = consumoAlcool;
        this.consumoGasolina = consumoGasolina;
    }

    @Override
    public int getConsumo(TipoCombustivel tipoCombustivel) throws Exception {
        if (tipoCombustivel == TipoCombustivel.ALCOOL) {
            return consumoAlcool;
        } else if (tipoCombustivel == TipoCombustivel.GASOLINA) {
            return consumoGasolina;
        }
        throw new Exception("Tipo de Combustível não suportado");
    }

    @Override
    public TipoCombustivel getTipoMotor() {
        return TipoCombustivel.FLEX;
    }

    @Override
    public int getQuilometragem() {
        return quilometragem;
    }

    @Override
    public int combustivelNecessario(int distancia, TipoCombustivel tipoCombustivel) throws Exception {
        if (tipoCombustivel == TipoCombustivel.ALCOOL) {
            return distancia/consumoAlcool;
        } else if (tipoCombustivel == TipoCombustivel.GASOLINA) {
            return distancia/consumoGasolina;
        }
        throw new Exception("Tipo de Combustível não suportado");
    }

    @Override
    public void percorre(int distancia) {
        quilometragem += distancia;
    }

    @Override
    public String toString() {
        return "Motor [consumoAlcool=" + consumoAlcool + ", consumoGasolina=" + consumoGasolina + ", quilometragem=" + quilometragem + ", tipoMotor=" + "Flex" + "]";
    }
}
