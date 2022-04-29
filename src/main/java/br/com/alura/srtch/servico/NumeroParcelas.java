package br.com.alura.srtch.servico;

import java.util.InputMismatchException;

public class NumeroParcelas {

    private final Integer numeroParcelas = 0;

    public final Integer parecelas(){

        try{
            verificarParcelas(numeroParcelas);
        }catch (InputMismatchException r){
            r.printStackTrace();
        }
        return numeroParcelas;
    }

    public void verificarParcelas(Integer numeroParcelas){
        if(numeroParcelas <1 || numeroParcelas > 12){
            throw new IllegalArgumentException("Número maximo de Parcelas são 12");
        }
    }
}
