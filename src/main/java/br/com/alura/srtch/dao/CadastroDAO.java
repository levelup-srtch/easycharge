package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cadastro;

import javax.persistence.EntityManager;
import java.util.List;

public class CadastroDAO {

    private EntityManager em;

    public CadastroDAO(EntityManager em) {
        this.em = em;
    }

    public List<Cadastro> buscarTodos() {
        String jpql = "SELECT c FROM Cadastro c";
        return em.createQuery(jpql, Cadastro.class).getResultList();
    }

    public Cadastro buscarPorId(Long id) {
        return em.find(Cadastro.class, id);
    }

    public void cadastrar(Cadastro cadastro){
        this.em.persist(cadastro);
    }

    public void atualizar(Cadastro cadastro) {
        this.em.merge(cadastro);
    }

}
