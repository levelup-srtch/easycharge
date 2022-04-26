package br.com.alura.srtch.dao;


import java.util.List;

import javax.persistence.EntityManager;

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
	
	public Divida buscarPorId(Long id) {
		return em.find(Divida.class, id);
	}
	
	public List<Divida> buscarTodos() {	
		String jpql = "SELECT c FROM divida c";
		return em.createQuery(jpql, Divida.class).getResultList();
	}
	
	
	public List<Divida> buscarPorDividaSemCobranca() {	
		String jpql = "SELECT c FROM divida c WHERE c.cobranca is null"; 
		return em.createQuery(jpql, Divida.class)
				.getResultList();
	}
	

}
