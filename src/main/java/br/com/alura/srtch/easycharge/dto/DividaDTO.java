package br.com.alura.srtch.easycharge.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.srtch.easycharge.modelo.Divida;
import br.com.alura.srtch.easycharge.modelo.StatusDivida;

public class DividaDTO {

    private Long id;

    private BigDecimal valor;

    private Date dataDeAbertura;

    private Date dataDeQuitacao;

    private StatusDivida status;

    private String descricaoDeQuitacao;

    private Long idCliente;

    public DividaDTO() {
    }

    public DividaDTO(Divida divida){
        this.id = divida.getIdDivida();
        this.valor = divida.getValorDaDivida();
        this.dataDeAbertura = divida.getDataDeAbertura();
        this.dataDeQuitacao = divida.getDataDeQuitacao();
        this.status = divida.getStatus();
        this.descricaoDeQuitacao = divida.getDescricaoDeQuitacao();
        this.idCliente = divida.getCliente().getId();
    }

	public DividaDTO(Long id, BigDecimal valor, Date dataDeAbertura, Date dataDeQuitacao, StatusDivida status,
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

	@Override
	public String toString() {
		return "DividaDTO [id=" + id + ", valor=" + valor + ", dataDeAbertura=" + dataDeAbertura + ", dataDeQuitacao="
				+ dataDeQuitacao + ", status=" + status + ", descricaoDeQuitacao=" + descricaoDeQuitacao
				+ ", idCliente=" + idCliente + "]";
	}

	public static List<DividaDTO> convert(List<Divida> dividas) {
		return dividas.stream().map(DividaDTO::new).collect(Collectors.toList());
	}
    
}