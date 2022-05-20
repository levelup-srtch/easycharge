package br.com.alura.srtch.easycharge.form;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.modelo.StatusDivida;

public class DividaForm {

    private Long id;
    @Positive
    private BigDecimal valor;
    @NotNull @PastOrPresent
    private Date dataDeAbertura;
    @PastOrPresent
    private Date dataDeQuitacao;
    @NotNull
    private StatusDivida status;

    private String descricaoDeQuitacao;
    @NotNull
    private Long idCliente;

    public DividaForm() {
    }

    public DividaForm(Divida divida){
        this.id = divida.getId();
        this.valor = divida.getValorDaDivida();
        this.dataDeAbertura = divida.getDataDeAbertura();
        this.dataDeQuitacao = divida.getDataDeQuitacao();
        this.status = divida.getStatus();
        this.descricaoDeQuitacao = divida.getDescricaoDeQuitacao();
        this.idCliente = divida.getCliente().getId();
    }

	public DividaForm(Long id, BigDecimal valor, Date dataDeAbertura, Date dataDeQuitacao, StatusDivida status,
			String descricaoDeQuitacao, Long idCliente) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataDeAbertura = dataDeAbertura;
		this.dataDeQuitacao = dataDeQuitacao;
		this.status = status;
		this.descricaoDeQuitacao = descricaoDeQuitacao;
		this.idCliente = idCliente;
	}

	 public Long idCliente() {
	        return idCliente;
	    }
	
	public Divida toDivida() {
		Divida divida = new Divida();
		Cliente cliente = new Cliente(idCliente());
		divida.setCliente(cliente);
		divida.setDataDeAbertura(dataDeAbertura);
		divida.setDataDeQuitacao(dataDeQuitacao);
		divida.setDescricaoDeQuitacao(descricaoDeQuitacao);
		divida.setStatus(status);
		divida.setValorDaDivida(valor);
		
		return divida;
		
		
	}
	
	
	
	public Long getId() {
		return id;
	}
	
	
	public BigDecimal getValor() {
		return valor;
	}
	
	
	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}
	
	
	public Date getDataDeQuitacao() {
		return dataDeQuitacao;
	}
	

	public StatusDivida getStatus() {
		return status;
	}

	public String getDescricaoDeQuitacao() {
		return descricaoDeQuitacao;
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	
	

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}

	public void setDataDeQuitacao(Date dataDeQuitacao) {
		this.dataDeQuitacao = dataDeQuitacao;
	}

	public void setStatus(StatusDivida status) {
		this.status = status;
	}

	public void setDescricaoDeQuitacao(String descricaoDeQuitacao) {
		this.descricaoDeQuitacao = descricaoDeQuitacao;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "DividaDTO [id=" + id + ", valor=" + valor + ", dataDeAbertura=" + dataDeAbertura + ", dataDeQuitacao="
				+ dataDeQuitacao + ", status=" + status + ", descricaoDeQuitacao=" + descricaoDeQuitacao
				+ ", idCliente=" + idCliente + "]";
	}

	
	
	
	public static List<DividaForm> convert(List<Divida> dividas) {
		return dividas.stream().map(DividaForm::new).collect(Collectors.toList());
	}
    
}