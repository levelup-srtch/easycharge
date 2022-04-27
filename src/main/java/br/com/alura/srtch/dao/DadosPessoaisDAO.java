package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.DadosPessoais;

import javax.persistence.EntityManager;
import java.util.List;

public class DadosPessoaisDAO {

    private EntityManager em;

    public DadosPessoaisDAO(EntityManager em) {
        this.em = em;
    }

    public List<DadosPessoais> buscarTodos() {
        String jpql = "SELECT c FROM DadosPessoais c";
        return em.createQuery(jpql, DadosPessoais.class).getResultList();
    }

    public DadosPessoais buscarPorId(String cpf) {
        return em.find(DadosPessoais.class, cpf);
    }

    public void cadastrar(DadosPessoais cadastro){
        this.em.persist(cadastro);
    }

    public void atualizar(DadosPessoais cadastro) {
        this.em.merge(cadastro);
    }

}
