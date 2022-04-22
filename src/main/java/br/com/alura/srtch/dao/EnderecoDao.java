package br.com.alura.srtch.dao;


import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.srtch.*;
import modelo.Endereco;

public class EnderecoDao {
	private EntityManager em;

	public EnderecoDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Endereco endereco) {
		this.em.persist(endereco);
	}
	
	public void atualizar(Endereco endereco) {
		this.em.merge(endereco);
	}
	
	public void remover(Endereco endereco) {
		endereco = em.merge(endereco); // só remove se o objeto estiver managed
		this.em.remove(endereco);
	}
	
	public Endereco buscarPorId(Long id) {
		return em.find(Endereco.class, id);
	}
	
	/*
	public List<Cliente> buscarTodos() {	
		String jpql = "SELECT c FROM Cliente c";
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscarPorNome(String nome) {	
		String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome"; // também funciona de :nome para ?1 indicando a posição 1
		return em.createQuery(jpql, Cliente.class).setParameter("nome",nome).getResultList(); // também funciona de "nome" para 1, indicando a posição 1
	}
	
	public List<Cliente> buscarPorAtivo() {	
		String jpql = "SELECT c FROM Cliente c WHERE c.status = 'Ativo'"; 
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	public List<Cliente> buscarPorSuspenso() {	
		String jpql = "SELECT c FROM Cliente c WHERE c.status = 'Suspenso'"; 
		return em.createQuery(jpql, Cliente.class).getResultList();
	}
	
	*/
}
