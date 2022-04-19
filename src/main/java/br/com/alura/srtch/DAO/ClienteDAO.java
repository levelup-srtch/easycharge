package br.com.alura.srtch.DAO;

import br.com.alura.srtch.dominio.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(String cpf) {
        return em.find(Cliente.class, cpf);
    }

    public void atualizar(Cliente cliente){
        this.em.merge(cliente);
    }

    public void deletear(Cliente cliente){
        cliente = em.merge(cliente);
        this.em.remove(cliente);
    }

    public List<Cliente> buscarTodosPorTodos(Cliente cliente){
        String sql = "SELECT a FROM Cliente a";
        return em.createQuery(sql,Cliente.class).getResultList();
    }

    public List<Cliente> buscarTodosAtivos() {
        String sql = "SELECT a FROM Cliente a WHERE a.status = 'ATIVO'";
        return em.createQuery(sql, Cliente.class).getResultList();
    }

    public List<Cliente> buscarTodosSuspenso() {
        String sql = "SELECT a FROM Cliente a WHERE a.status = 'SUSPENSO'";
        return em.createQuery(sql, Cliente.class).getResultList();
    }
}
