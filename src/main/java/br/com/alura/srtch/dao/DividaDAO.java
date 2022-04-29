package br.com.alura.srtch.dao;

import br.com.alura.srtch.dto.RelatorioDeDividasDTO;
import br.com.alura.srtch.modelo.Divida;

import javax.persistence.EntityManager;
import java.util.List;

import static br.com.alura.srtch.service.CobrancasDaDivida.removerCobrancas;

public class DividaDAO {

    private EntityManager em;

    public DividaDAO(EntityManager em) {
        this.em = em;
    }

    public Divida buscarPorId(long id) {
        return em.find(Divida.class, id);
    }

    public void cadastrar(Divida divida){
        this.em.persist(divida);
    }

    public void atualizar(Divida divida) {
        this.em.merge(divida);
    }

    public void remover(Long id) {
        removerCobrancas(id, em);
        Divida divida = em.find(Divida.class, id);
        this.em.remove(divida);
    }

    public List<Divida> buscarDividasSemCobranca() {
        String jpql = "SELECT d FROM Divida d WHERE d.cobrancas IS EMPTY";
        return em.createQuery(jpql, Divida.class)
                .getResultList();
    }

    public List<Divida> buscarTodos() {
        String jpql = "SELECT d FROM Divida d";
        return em.createQuery(jpql, Divida.class).getResultList();
    }

    public Divida buscarDividaComCliente(Long id){
        return em.createQuery("SELECT d FROM Divida d " +
                        "JOIN FETCH d.cliente c " +
                        "JOIN FETCH c.dadosPessoais " +
                        "JOIN FETCH c.endereco " +
                        "WHERE d.id = :id", Divida.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public List<RelatorioDeDividasDTO> totalDeDividasECobrancas(){
        String jpql = "SELECT new br.com.alura.srtch.dto.RelatorioDeDividasDTO("
                + "cliente.dadosPessoais.nome, "
                + "SUM(d.valorDaDivida), "
                + "d.cobrancas.size()) "
                + "FROM Divida d "
                + "JOIN d.cliente cliente "
                + "GROUP BY cliente.dadosPessoais.nome";
        return em.createQuery(jpql, RelatorioDeDividasDTO.class)
                .getResultList();
    }

}
