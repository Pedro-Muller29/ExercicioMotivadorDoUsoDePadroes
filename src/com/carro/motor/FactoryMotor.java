package com.carro.motor;

import com.carro.TipoCombustivel;

public class FactoryMotor {
    public static Motor geMotorComum(TipoCombustivel tipoCombustivel, int consumo) {
        return new MotorComum(tipoCombustivel, consumo);
    }

    public static Motor getMotorFlex(int consumoAlcool, int consumoGasolina) {
        return new MotorFlex(consumoAlcool, consumoGasolina);
    }

    public static Motor getMotorEconomico(TipoCombustivel tipoCombustivel, int consumoInicial, int consumoMinimo, int kmPorDecaimento) {
        return new MotorEconomico(tipoCombustivel, consumoInicial, consumoMinimo, kmPorDecaimento);
    }
}
