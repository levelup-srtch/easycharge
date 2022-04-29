package br.com.alura.srtch.service;

public class Parcelas {

    private static final Integer numeroDeParcelas = 6;

    public static Integer receberNumeroDeParcelas(){
//    Scanner input = new Scanner(System.in);
    try{
//        System.out.println("Digite o número de parcelas que deseja pagar (De 1 a 12 meses): ");
//        numeroDeParcelas = input.nextInt();
        verificarNumeroDeParcelas(numeroDeParcelas);
    }catch(Exception e){
        e.printStackTrace();
        e.getCause();
    }
    return numeroDeParcelas;
}

    public static void verificarNumeroDeParcelas(Integer numeroDeParcelas){
        if(numeroDeParcelas < 1 || numeroDeParcelas > 12){
            throw new IllegalArgumentException("Número de parcelas inválida, tente de 1 a 12 parcelas!");
        }
    }

}
