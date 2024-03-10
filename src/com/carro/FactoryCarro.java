package com.carro;

public class FactoryCarro {
    public static Carro getCarro(ModeloCarro modelo) {
        if (modelo == ModeloCarro.BASICO) {
            return new Carro(modelo, TipoCombustivel.GASOLINA, 10, 55);
        } else if (modelo == ModeloCarro.ESPORTIVO) {
            return new Carro(modelo, TipoCombustivel.GASOLINA, 6, 45);
        } else if (modelo == ModeloCarro.UTILITARIO) {
            return new Carro(modelo, TipoCombustivel.DIESEL, 5, 70);
        }
        return null;
    }
}
