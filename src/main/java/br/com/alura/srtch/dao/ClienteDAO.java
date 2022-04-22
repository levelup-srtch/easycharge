package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.StatusCliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> buscarTodos() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> buscarTodosPorStatus(StatusCliente statusCliente) {
        String jpql = "SELECT c FROM Cliente c WHERE c.cadastro.status = :status";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("status", statusCliente)
                .getResultList();
    }

    public List<Cliente> buscarPorNome(String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE c.nome = :nome";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public Cliente buscarPorId(String cpf) {
        return em.find(Cliente.class, cpf);
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public void atualizar(Cliente cliente) {
        this.em.merge(cliente);
    }

    public void remover(Cliente cliente) {
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

}
