package com.carro.motor;

import com.carro.TipoCombustivel;

public interface Motor {
    public int getConsumo(TipoCombustivel tipoCombustivel) throws Exception;

    public TipoCombustivel getTipoMotor();

    public int getQuilometragem();

    public int combustivelNecessario(int distancia, TipoCombustivel tipoCombustivel) throws Exception;    

    public void percorre(int distancia);
}
