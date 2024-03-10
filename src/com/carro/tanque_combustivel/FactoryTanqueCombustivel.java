package com.carro.tanque_combustivel;

import com.carro.TipoCombustivel;

public class FactoryTanqueCombustivel {
    public static TanqueCombustivel getTanque(TipoCombustivel tipoCombustivel, int capacidade) {
        if (tipoCombustivel == TipoCombustivel.FLEX) {
            return new TanqueCombustivelFlex(capacidade);
        } else {
            return new TanqueCombustivelComum(tipoCombustivel, capacidade);
        }
    }
}
