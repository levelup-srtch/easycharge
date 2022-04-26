package br.com.alura.srtch.DAO;


import br.com.alura.srtch.dominio.Divida;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DividaDAO {

    private EntityManager em;

    public DividaDAO(EntityManager em){
        this.em = em;
    }
    public void cadastrar(Divida divida){
        this.em.persist(divida);
    }
    public void atualizar(Divida divida){
        this.em.merge(divida);
    }
    public void deletar(Divida divida){
        divida = em.merge(divida);
        this.em.remove(divida);
    }

    public Divida buscarPorId(String id){
        return em.find(Divida.class, id);
    }

    public List <Divida> buscarTododas(){
        String jpql = "SELECT  a FROM Divida a";
        return em.createQuery(jpql, Divida.class).getResultList();
    }
    public List <Divida> buscarPorParametos(BigDecimal valor, LocalDate dataAbertura,LocalDate dataQuitacao){
       CriteriaBuilder builder = em.getCriteriaBuilder();
       CriteriaQuery <Divida> query = builder.createQuery(Divida.class);
       Root<Divida> from = query.from(Divida.class);

        Predicate filtros = builder.and();
       if (valor != null){
            builder.and(filtros,builder.equal(from.get("valor"), valor));
       }
        if (dataAbertura != null ){
            builder.and(filtros,builder.equal(from.get("dataAbertura"), dataAbertura));
        }
        if (dataQuitacao != null ){
            builder.and(filtros,builder.equal(from.get("dataQuitacao"), dataQuitacao));
        }
        query.where(filtros);

    }
}
