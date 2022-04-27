package br.com.alura.srtch.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Parcelas {

    private static Integer numeroDeParcelas;

    public static Integer receberNumeroDeParcelas(){
    Scanner input = new Scanner(System.in);
    try{
        System.out.println("Digite o número de parcelas que deseja pagar (De 1 a 12 meses): ");
        numeroDeParcelas = input.nextInt();
        verificarNumeroDeParcelas(numeroDeParcelas);
    }catch(InputMismatchException e){
        e.printStackTrace();
    }
    return numeroDeParcelas;
}

    public static void verificarNumeroDeParcelas(Integer numeroDeParcelas){
        if(numeroDeParcelas < 1 || numeroDeParcelas > 12){
            throw new IllegalArgumentException("Número de parcelas inválida, tente de 1 a 12 parcelas!");
        }
    }

}
