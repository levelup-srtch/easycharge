package br.com.alura.srtch.DAO;

import br.com.alura.srtch.dominio.Cobranca;
import br.com.alura.srtch.dominio.enuns.TipoDeAcordo;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CobracaDAO {

    private EntityManager em;

    public CobracaDAO (EntityManager em){
        this.em =em;
    }
    public void cadastrar(Cobranca cobranca){
        this.em.persist(cobranca);
    }
    public void atualizar(Cobranca cobranca){
        this.em.merge(cobranca);
    }
    public void deletar(Cobranca cobranca){
        cobranca = em.merge(cobranca);
        this.em.remove(cobranca);
    }
    public Cobranca buscarPorId(Long id){
        return em.find(Cobranca.class,id);
    }
    public List<Cobranca> buscarPorAcordos(TipoDeAcordo tipoDeAcordo){
        String jpql = "SELECT a FROM Cobranca a WHERE a.tipoDeAcordo = :tipoDeAcordo";
        return em.createQuery(jpql, Cobranca.class)
                .setParameter("tipoDeAcordo",tipoDeAcordo).getResultList();
    }
    public List <Cobranca> buscarSemAcordo(){
        String jpql = "SELECT a FROM Cobranca a WHERE a.tipoDeAcordo IS NULL";
        return em.createQuery(jpql,Cobranca.class).getResultList();
    }
    public List<Cobranca> buscarTodos(){
        String jpql = "SELECT a FROM Cobranca a";
        return em.createQuery(jpql,Cobranca.class).getResultList();
    }
}
