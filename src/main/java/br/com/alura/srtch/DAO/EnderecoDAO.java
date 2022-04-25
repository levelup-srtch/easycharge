package br.com.alura.srtch.DAO;

import br.com.alura.srtch.dominio.Endereco;

import javax.persistence.EntityManager;
import java.util.List;

public class EnderecoDAO {
    private EntityManager em;

    public EnderecoDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Endereco endereco){
        this.em.persist(endereco);
    }
    public void atualizar(Endereco endereco){
        this.em.merge (endereco);
    }

    public void deletear(Endereco endereco){
        endereco = em.merge(endereco);
        this.em.remove(endereco);
    }
    public List<Endereco> buscarTodosPorId(Endereco endereco){
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql,Endereco.class).getResultList();
    }
}
