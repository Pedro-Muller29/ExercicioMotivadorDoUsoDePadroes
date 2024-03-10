package com.carro.tanque_combustivel;

import com.carro.TipoCombustivel;

public class TanqueCombustivelFlex implements TanqueCombustivel {

    private int capacidade;
    private int alcoolDisponivel;
    private int gasolinaDisponivel;

    TanqueCombustivelFlex(int quantidade) {
        this.capacidade = quantidade;
        this.alcoolDisponivel = 0;
        this.gasolinaDisponivel = 0;
    }

    @Override
    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public int getCombustivelDisponivel(TipoCombustivel tipoCombustivel) {
        if (tipoCombustivel == TipoCombustivel.ALCOOL) {
            return alcoolDisponivel;
        } else if (tipoCombustivel == TipoCombustivel.GASOLINA) {
            return gasolinaDisponivel;
        }
        return 0;
    }

    @Override
    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        // Garante que o combustível é Alcool ou Gasolina
        if (tipoCombustivel == TipoCombustivel.ALCOOL || tipoCombustivel == TipoCombustivel.GASOLINA) {
            // Verifica se a quantidade a ser inserida é menor ou igual a capacidade restante no tanque
            if (quantidade <= (capacidade-alcoolDisponivel-gasolinaDisponivel)) {
                // Enche o tanque com essa quantidade
                if (tipoCombustivel == TipoCombustivel.ALCOOL) {
                    alcoolDisponivel += quantidade;
                } else {
                    gasolinaDisponivel += quantidade;
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean gasta(int quantidade, TipoCombustivel tipoCombustivel) {
        if (tipoCombustivel == TipoCombustivel.ALCOOL) {
            if (alcoolDisponivel >= quantidade) {
                alcoolDisponivel -= quantidade;
                return true;
            }
        }
        if (tipoCombustivel == TipoCombustivel.GASOLINA) {
            if (gasolinaDisponivel >= quantidade) {
                gasolinaDisponivel -= quantidade;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "TanqueCombustivel [capacidade=" + capacidade + ", alcoolDisponivel=" + 
                alcoolDisponivel + ", gasolinaDisponivel=" + gasolinaDisponivel
                + ", tipoCombustivel=" + "Flex" + "]";
    }
}
