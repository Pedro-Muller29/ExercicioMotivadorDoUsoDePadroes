package com.carro.tanque_combustivel;

import com.carro.TipoCombustivel;

public interface TanqueCombustivel {
    public int getCapacidade();

    public int getCombustivelDisponivel(TipoCombustivel tipoCombustivel);

    public int getCapacidadeDisponivel();

    public boolean abastece(TipoCombustivel tipoCombustivel, int quantidade);

    public boolean gasta(int quantidade, TipoCombustivel tipoCombustivel);
}
