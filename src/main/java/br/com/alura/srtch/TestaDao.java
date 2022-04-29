package br.com.alura.srtch;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.CobrancaDao;
import br.com.alura.srtch.dao.DividaDao;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Cobranca;
import br.com.alura.srtch.modelo.Divida;
import br.com.alura.srtch.modelo.Endereco;
import br.com.alura.srtch.modelo.MeioDeContato;
import br.com.alura.srtch.modelo.StatusCliente;
import br.com.alura.srtch.modelo.StatusDivida;
import br.com.alura.srtch.modelo.TipoDeAcordo;
import br.com.alura.srtch.modelo.TipoDeAgente;
import br.com.alura.srtch.util.JPAUtil;

public class TestaDao {

	public static void main(String[] args) {
		  
		  EntityManager em = JPAUtil.getEntityManager();
		  ClienteDao clienteDao = new ClienteDao(em);
		  DividaDao dividaDao = new DividaDao(em);
		  CobrancaDao cobrancaDao = new CobrancaDao(em);
		  
		  
		  Cliente cliente = new Cliente(
					 "Yasmin Ester Lara Nogueira",
					 "040.141.961-43",
					 "(61) 98439-7036",
					 "yasminesternogueira@munhozengenharia.com.br",
					 "Engenheira",
					 new BigDecimal("9168"),
					 StatusCliente.ATIVO,
					 new Endereco("Quadra QS 20 Conjunto 2","669","ap 175","Riacho Fundo II","Brasília","DF"));
		  
		  Date novaData = new Date();
		  BigDecimal valor  = new BigDecimal(100);
		  BigDecimal valor2  = new BigDecimal(50);
		  Divida divida = new Divida(valor,novaData, novaData,StatusDivida.ATIVA, "NADA", cliente);
		  Divida divida2 = new Divida(valor2,novaData, novaData,StatusDivida.ATIVA, "NADA", cliente);
		  Cobranca cobranca = new Cobranca(novaData, MeioDeContato.TELEFONE, "JOÃO", TipoDeAgente.INTERNO, "teste", "vou pagar", TipoDeAcordo.PROMESSA, novaData, 10, divida);
		  
		  	em.getTransaction().begin(); 
			clienteDao.cadastrar(cliente);
			dividaDao.cadastrar(divida);
			dividaDao.cadastrar(divida2);
			cobrancaDao.cadastrar(cobranca); 
			em.getTransaction().commit(); 
			//em.close();
			
			 System.out.println(dividaDao.buscaTotalDividaCliente(cliente));;
	}

}
