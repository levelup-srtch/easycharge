package br.com.alura.srtch.dao;


import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.StatusCliente;
import br.com.alura.srtch.vo.RelatorioClienteVO;

public class ClienteDao {
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public void atualizar(Cliente cliente) {
		this.em.merge(cliente);
	}
	
	public void remover(Cliente cliente) {
		cliente = em.merge(cliente); // só remove se o objeto estiver managed
		this.em.remove(cliente);
	}
	
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> buscarTodos() {	
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscarPorNome(String nome) {	
		String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome"; // também funciona de :nome para ?1 indicando a posição 1
		return em.createQuery(jpql, Cliente.class).setParameter("nome",nome).getResultList(); // também funciona de "nome" para 1, indicando a posição 1
	}
	
	public List<Cliente> buscarPorAtivo(StatusCliente status) {	
		String jpql = "SELECT c FROM Cliente c WHERE c.status = :status"; 
		return em.createQuery(jpql, Cliente.class)
				.setParameter("status", status )
				.getResultList();
	}
	
	public List<Cliente> buscarPorSuspenso(StatusCliente status) {	
		String jpql = "SELECT c FROM Cliente c WHERE c.status = :status"; 
		return em.createQuery(jpql, Cliente.class)
				.setParameter("status", status )
				.getResultList();
	}

	
	public List<RelatorioClienteVO> relatorioDeCliente() {
		String jpql = "SELECT new br.com.alura.srtch.vo.RelatorioClienteVO("
				+ "cliente.nome, "
				//+ "SUM(divida.valorTotalDivida), "
				//+ "COUNT(cobranca.id) "
				+ "FROM Cliente cliente ";
				//+ "JOIN divida.cobranca cobranca "
				//+ "JOIN cobranca.divida divida "
				//+ "GROUP BY cliente.nome ";
				//+ "ORDER BY item.quantidade DESC";
		return em.createQuery(jpql, RelatorioClienteVO.class)
				.getResultList();
	}
}
