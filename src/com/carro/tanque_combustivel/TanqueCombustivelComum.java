package com.carro.tanque_combustivel;

import com.carro.TipoCombustivel;

class TanqueCombustivelComum implements TanqueCombustivel {

    private TipoCombustivel tipoCombustivel;
    private int capacidade;
    private int combustivelDisponivel;

    TanqueCombustivelComum(TipoCombustivel tipoCombustivel, int capacidade) {
        this.tipoCombustivel = tipoCombustivel;
        this.capacidade = capacidade;
        this.combustivelDisponivel = 0;
    }

    public TipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getCombustivelDisponivel(TipoCombustivel tipoCombustivel) {
        if (tipoCombustivel != this.tipoCombustivel) {
            return 0;
        }
        return combustivelDisponivel;
    }

    public int getCapacidadeDisponivel() {
        return capacidade - combustivelDisponivel;
    }

    // Retorna false se o tipo de combustivel for incompativel ou se a quantidade
    // for maior que a capacidade livre
    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        if (tipoCombustivel != this.tipoCombustivel) {
            return false;
        }
        if (getCombustivelDisponivel(this.tipoCombustivel) + quantidade > getCapacidade()) {
            return false;
        } else {
            combustivelDisponivel += quantidade;
            return true;
        }
    }

    public boolean gasta(int quantidade, TipoCombustivel tipoCombustivel) {
        if (tipoCombustivel != this.tipoCombustivel) {
            return false;
        }
        if (getCombustivelDisponivel(this.tipoCombustivel) - quantidade < 0) {
            return false;
        } else {
            combustivelDisponivel -= quantidade;
            return true;
        }
    }

    @Override
    public String toString() {
        return "TanqueCombustivel [capacidade=" + capacidade + ", combustivelDisponivel=" + combustivelDisponivel
                + ", tipoCombustivel=" + tipoCombustivel + "]";
    }

}
