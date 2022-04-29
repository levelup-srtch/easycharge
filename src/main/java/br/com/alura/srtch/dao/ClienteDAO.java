package br.com.alura.srtch.dao;

import br.com.alura.srtch.dto.RelatorioDoClienteDTO;
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
        String jpql = "SELECT c FROM Cliente c WHERE c.status = :status";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("status", statusCliente)
                .getResultList();
    }

    public List<Cliente> buscarPorNome(String nome) {
        String jpql = "SELECT c FROM Cliente c WHERE c.dadosPessoais.nome = :nome";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Cliente> buscarPorCpf(String cpf) {
        String jpql = "SELECT c FROM Cliente c WHERE c.dadosPessoais.cpf = :cpf";
        return em.createQuery(jpql, Cliente.class)
                .setParameter("cpf", cpf)
                .getResultList();
    }

//    public List<RelatorioDoClienteDTO> relatorioDocliente(){
//        String jpql = "SELECT new br.com.alura.srtch.dto.RelatorioDoClienteDTO("
//                + "cliente.dadosPessoais.nome, "
//                + "SUM(d.valor), "
//                + "d.cobrancas.size()) "
//                + "FROM Divida d "
//                + "JOIN d.cliente cliente "
//                + "GROUP BY cliente.dadosPessoais.nome";
//        return em.createQuery(jpql, RelatorioDoClienteDTO.class)
//                .getResultList();
//    }

    public List<RelatorioDoClienteDTO> relatorioDoCliente(){
        String jpql = "SELECT new br.com.alura.srtch.dto.RelatorioDoClienteDTO ("
                + "c.dadosPessoais.nome, "
                + "SUM(d.valor), "
                + "COUNT(cobranca)) "
                + "FROM Cobranca cobranca "
                + "JOIN cobranca.divida d "
                + "JOIN d.cliente c "
                + "GROUP BY c.dadosPessoais.nome";
        return em.createQuery(jpql, RelatorioDoClienteDTO.class)
                .getResultList();

    }

    public Cliente buscarPorId(long id) {
        return em.find(Cliente.class, id);
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
