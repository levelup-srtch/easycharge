package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cobranca;

import javax.persistence.EntityManager;
import java.util.List;

public class CobrancaDAO {

    private EntityManager em;

    public CobrancaDAO(EntityManager em) {
        this.em = em;
    }

    public List<Cobranca> buscarTodos() {
        String jpql = "SELECT c FROM Cobranca c";
        return em.createQuery(jpql, Cobranca.class).getResultList();
    }

    public Cobranca buscarPorId(long id) {
        return em.find(Cobranca.class, id);
    }

    public void cadastrar(Cobranca cobranca){
        this.em.persist(cobranca);
    }

    public void atualizar(Cobranca cobranca) {
        this.em.merge(cobranca);
    }

    public void remover(Cobranca cobranca) {
        cobranca = em.merge(cobranca);
        this.em.remove(cobranca);
    }

}
