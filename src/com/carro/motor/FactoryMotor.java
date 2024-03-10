package com.carro.motor;

import com.carro.TipoCombustivel;

public class FactoryMotor {
    public static Motor geMotorComum(TipoCombustivel tipoCombustivel, int consumo) {
        return new MotorComum(tipoCombustivel, consumo);
    }

    public static Motor getMotorFlex(int consumoAlcool, int consumoGasolina) {
        return new MotorFlex(consumoAlcool, consumoGasolina);
    }
}
