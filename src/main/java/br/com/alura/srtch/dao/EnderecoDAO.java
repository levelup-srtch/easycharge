package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Endereco;

import javax.persistence.EntityManager;

public class EnderecoDAO {

    private EntityManager em;

    public EnderecoDAO(EntityManager em) {
        this.em = em;
    }

    public Endereco buscarPorId(Long id) {
        return em.find(Endereco.class, id);
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }

    public void atualizar(Endereco endereco) {
        this.em.merge(endereco);
    }

}
