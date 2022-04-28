package br.com.alura.srtch.DAO;

import br.com.alura.srtch.dominio.Cliente;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(String id) {
        return em.find(Cliente.class, id);
    }

    public void atualizar(Cliente cliente){
        this.em.merge(cliente);
    }

    public void deletear(Cliente cliente){
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

    public List<Cliente> buscarTodos(){
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql,Cliente.class).getResultList();
    }

    public List<Cliente> buscarTodosAtivos() {
        String jpql = "SELECT c FROM Cliente c WHERE c.status = 'ATIVO'";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public List<Cliente> buscarTodosSuspenso() {
        String jpql = "SELECT c FROM Cliente c WHERE c.status = 'SUSPENSO'";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public BigDecimal somarDividasDosClientes(Long id){
        String jpql = "SELECT SUM(a.valor)from Divida a WHERE a.statusDivida = 'ABERTA'AND a.cliente.id = :id";
        return (BigDecimal) em.createQuery(jpql, BigDecimal.class).getResultList();
    }
}
