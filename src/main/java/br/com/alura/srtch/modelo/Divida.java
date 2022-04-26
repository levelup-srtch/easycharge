package br.com.alura.srtch.modelo;

import java.util.Date;

public class Divida {

	private double valorDaDivida;
	private Date dataDeAbertura;
	private Date dataDeQuitacao;
	private StatusDivida status; //enum
 	private String descricaoDeQuitacao;
 	private Cliente cliente;
	
	
}
