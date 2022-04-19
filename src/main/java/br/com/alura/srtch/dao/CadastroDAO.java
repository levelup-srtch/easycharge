package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cliente;

import javax.persistence.EntityManager;

public class CadastroDAO {

    private EntityManager em;

    public CadastroDAO(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

}
