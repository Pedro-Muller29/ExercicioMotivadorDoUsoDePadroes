package com.carro;

import com.carro.motor.FactoryMotor;

public class FactoryCarro {
    public static Carro getCarro(ModeloCarro modelo) {
        if (modelo == ModeloCarro.BASICO) {
            return new Carro(modelo,
             TipoCombustivel.GASOLINA,
              FactoryMotor.geMotorComum(TipoCombustivel.GASOLINA, 10),
               55);
        } else if (modelo == ModeloCarro.ESPORTIVO) {
            return new Carro(modelo,
             TipoCombustivel.GASOLINA,
             FactoryMotor.geMotorComum(TipoCombustivel.GASOLINA, 6),
              45);
        } else if (modelo == ModeloCarro.UTILITARIO) {
            return new Carro(modelo,
             TipoCombustivel.DIESEL,
             FactoryMotor.geMotorComum(TipoCombustivel.DIESEL, 6),
              70);
        } else if (modelo == ModeloCarro.SUV) {
            return new Carro(modelo,
             TipoCombustivel.FLEX,
              FactoryMotor.geMotorComum(TipoCombustivel.GASOLINA, 8),
               55);
        } else if (modelo == ModeloCarro.SUVFlex) {
            return new Carro(modelo,
             TipoCombustivel.FLEX,
              FactoryMotor.getMotorFlex(6, 8),
               65);
        }
        return null;
    }
}
