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
		  
		  Cliente cliente2 = new Cliente(
					 "Teston Teste Testemundo",
					 "321158789",
					 "(61) 656466-85648",
					 "dino@sauro.com.br",
					 "Pedreiro",
					 new BigDecimal("854"),
					 StatusCliente.ATIVO,
					 new Endereco("Beco  4","545","ap 02","Vila Oculta da Folha","Pais do Fogo","QG")); 
		  
		  
		  Date novaData = new Date();
		  BigDecimal valor  = new BigDecimal(100);
		  BigDecimal valor2  = new BigDecimal(50);
		  Divida divida = new Divida(valor,novaData, novaData,StatusDivida.ATIVA, "NADA", cliente);
		  Divida divida2 = new Divida(valor2,novaData, novaData,StatusDivida.ATIVA, "CADE A COBRANCA", cliente);
		  Cobranca cobranca = new Cobranca(novaData, MeioDeContato.TELEFONE, "JOÃO", TipoDeAgente.INTERNO, "teste", "vou pagar", TipoDeAcordo.PROMESSA, novaData, 10, divida);
		  Cobranca cobranca2 = new Cobranca(novaData, MeioDeContato.TELEFONE, "Bernardo", TipoDeAgente.INTERNO, "teste", "é talvez eu pague", TipoDeAcordo.PROMESSA, novaData, 10, divida);

		  	em.getTransaction().begin(); 
			clienteDao.cadastrar(cliente);
			clienteDao.cadastrar(cliente2);
			dividaDao.cadastrar(divida);
			dividaDao.cadastrar(divida2);
			cobrancaDao.cadastrar(cobranca); 
			cobrancaDao.cadastrar(cobranca2); 
			//em.getTransaction().commit(); 
			
			
			em.flush();
			
			divida.setStatus(StatusDivida.QUITADA);
			dividaDao.atualizar(divida2);
			
			System.out.println(dividaDao.buscarPorId(1l));	
			
			em.clear();
			dividaDao.remover(divida);
			
			em.flush();
			
			em.getTransaction().commit(); 
			System.out.println(dividaDao.buscarTodos());
			
			
			//System.out.println(dividaDao.buscarTodos());
			//System.out.println(dividaDao.buscarPorDividaSemCobranca()); 
			//System.out.println(dividaDao.buscaTotalDividaCliente(cliente));
			//System.out.println(cobrancaDao.buscaTotalCobrancaCliente(1l));;
		
	}

}
