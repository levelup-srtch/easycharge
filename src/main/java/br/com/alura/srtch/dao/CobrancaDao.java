package br.com.alura.srtch.dao;


import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.srtch.modelo.Cobranca;
import br.com.alura.srtch.modelo.TipoDeAcordo;

public class CobrancaDao {
	private EntityManager em;

	public CobrancaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Cobranca cobranca) {
		this.em.persist(cobranca);
	}
	
	public void atualizar(Cobranca cobranca) {
		this.em.merge(cobranca);
	}
	
	public void remover(Cobranca cobranca) {
		cobranca = em.merge(cobranca); // só remove se o objeto estiver managed
		this.em.remove(cobranca);
	}
	
	public Cobranca buscarPorId(Long id) {
		return em.find(Cobranca.class, id);
	}
	
	public List<Cobranca> buscarTodos() {	
		String jpql = "SELECT c FROM Cobranca c";
		return em.createQuery(jpql, Cobranca.class).getResultList();
	}
	
	
	public List<Cobranca> buscarPorAcordo(TipoDeAcordo tipoDeAcordo) {	
		String jpql = "SELECT c FROM Cobranca c WHERE c.tipoDeAcordo = :tipoDeAcordo"; 
		return em.createQuery(jpql, Cobranca.class)
				.setParameter("tipoDeAcordo", tipoDeAcordo )
				.getResultList();
	}
	

}
