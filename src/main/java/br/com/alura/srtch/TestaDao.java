package br.com.alura.srtch;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import br.com.alura.srtch.vo.RelatorioClienteVO;

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
		  BigDecimal valor  = new BigDecimal(1000);
		  BigDecimal valor2  = new BigDecimal(70);
		  BigDecimal valor3  = new BigDecimal(30);
		  List<Divida> dividas = new ArrayList<>();
		  List<Cobranca> cobrancas = new ArrayList<>();
		  
		  dividas.add(new Divida(valor,novaData, novaData,StatusDivida.ATIVA, "NADA", cliente));
		  dividas.add(new Divida(valor2,novaData, novaData,StatusDivida.ATIVA, "CADE A COBRANCA", cliente));
		  
		  dividas.add(new Divida(valor3,novaData, novaData,StatusDivida.ATIVA, "HMMM???", cliente2));
		 // Divida divida = 
		  //Divida divida2 = 
		  
		  
		  cobrancas.add(new Cobranca(novaData, MeioDeContato.TELEFONE, "JOÃO", TipoDeAgente.INTERNO, "teste", "vou pagar", TipoDeAcordo.PROMESSA, novaData, 0,dividas.get(0)));
		  cobrancas.add(new Cobranca(novaData, MeioDeContato.TELEFONE, "Hugo", TipoDeAgente.INTERNO, "teste", "vou pagar", TipoDeAcordo.PROMESSA, novaData, 0,dividas.get(1)));
		  cobrancas.add(new Cobranca(novaData, MeioDeContato.TELEFONE, "Caio", TipoDeAgente.INTERNO, "teste", "vou pagar", TipoDeAcordo.PARCELAMENTO, novaData, 10,dividas.get(1)));
		  
		  
		  cobrancas.add(new Cobranca(novaData, MeioDeContato.TELEFONE, "Bernardo", TipoDeAgente.INTERNO, "teste", "é talvez eu pague", TipoDeAcordo.PROMESSA, novaData, 0, dividas.get(2)));
		 // Cobranca cobranca = new Cobranca(novaData, MeioDeContato.TELEFONE, "JOÃO", TipoDeAgente.INTERNO, "teste", "vou pagar", TipoDeAcordo.PROMESSA, novaData, 10,dividas.get(0));
		  //Cobranca cobranca2 = new Cobranca(novaData, MeioDeContato.TELEFONE, "Bernardo", TipoDeAgente.INTERNO, "teste", "é talvez eu pague", TipoDeAcordo.PROMESSA, novaData, 10, dividas.get(1));

		  	em.getTransaction().begin(); 
			clienteDao.cadastrar(cliente);
			clienteDao.cadastrar(cliente2);
			
			  for (Divida divida : dividas) {
		            dividaDao.cadastrar(divida);
		        }
			  
			  
			//dividaDao.cadastrar(dividas);
			//dividaDao.cadastrar(divida2);
			  
			  for (Cobranca cobranca : cobrancas) {
		            cobrancaDao.cadastrar(cobranca);
		        }
			  
			  
			//cobrancaDao.cadastrar(cobranca); 
			//cobrancaDao.cadastrar(cobranca2); 
			//em.getTransaction().commit(); 
			
			
			//em.flush();
			
			
			//divida.setStatus(StatusDivida.QUITADA);
			//dividaDao.atualizar(divida2);
			em.getTransaction().commit(); 
			
			//System.out.println(dividaDao.buscarPorId(1l));	
			
			
			//em.getTransaction().begin(); 
			
			//dividaDao.removePorId(dividas.get(0));  //  
			
			//em.getTransaction().commit(); 
			//em.flush();
			
			//em.getTransaction().commit();
			
			/*
			System.out.println(dividaDao.buscarTodos());
			
			
			System.out.println(dividaDao.buscarTodos());
			System.out.println(dividaDao.buscarPorDividaSemCobranca()); 
			System.out.println(dividaDao.buscaTotalDividaCliente(cliente));
			System.out.println(cobrancaDao.buscarPorAcordo(TipoDeAcordo.PARCELAMENTO));
			*/
			System.out.println(cobrancaDao.buscaTotalCobrancaCliente(2l)); // verificar
			
			List<RelatorioClienteVO> relatorio = clienteDao.relatorioDeCliente();
			relatorio.forEach(System.out::println);
			
			//System.out.println(dividaDao.buscarTodos());
			
	}

}
