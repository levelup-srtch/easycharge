package br.com.alura.srtch.dao;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Divida;

public class DividaDao {
	private EntityManager em;

	public DividaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Divida divida) {
		this.em.persist(divida);
	}
	
	public void atualizar(Divida divida) {
		this.em.merge(divida);
	}
	
	public void remover(Divida divida) {
		divida = em.merge(divida); // só remove se o objeto estiver managed
		this.em.remove(divida);
	}
	
	
	public void removePorId (Divida divida) {
		Query query = em.createQuery("delete from Cobranca c where c.divida = :id");
		query.setParameter("id", divida ).executeUpdate();
		remover(divida);
		
	}
	


	public Divida buscarPorId(Long id) {
		return em.find(Divida.class, id);
	}
	
	public List<Divida> buscarTodos() {	
		String jpql = "SELECT d FROM Divida d";
		return em.createQuery(jpql, Divida.class).getResultList();
	}
	
	
	public List<Divida> buscarPorDividaSemCobranca() {	
		String jpql = "SELECT d FROM Divida d where d.id not in (select c.divida from Cobranca c)"; 
		return em.createQuery(jpql, Divida.class)
				.getResultList();
	}
	
	
	public BigDecimal buscaTotalDividaCliente(Cliente cliente) {
		String jpql = "SELECT SUM(p.valorDaDivida) FROM Divida p WHERE p.cliente = :id";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("id", cliente)
				.getSingleResult();
	}
}
