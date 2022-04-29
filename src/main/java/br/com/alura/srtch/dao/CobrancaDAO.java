package br.com.alura.srtch.dao;

import br.com.alura.srtch.modelo.Cobranca;
import br.com.alura.srtch.modelo.TipoAcordo;
import br.com.alura.srtch.dto.RelatorioDeCobrancasDTO;

import javax.persistence.EntityManager;
import java.util.List;

public class CobrancaDAO {

    private EntityManager em;

    public CobrancaDAO(EntityManager em) {
        this.em = em;
    }

    public List<Cobranca> buscarCobrancasDaDivida(Long id) {
        String jpql = "SELECT c FROM Cobranca c WHERE c.divida.id = :id";
        return em.createQuery(jpql, Cobranca.class)
                .setParameter("id", id)
                .getResultList();
    }

    public Long somarNumeroDeCobrancas(Long id){
        String jpql = "SELECT COUNT(c) FROM Cobranca c WHERE c.divida.cliente.id = :id";
        return em.createQuery(jpql, Long.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public RelatorioDeCobrancasDTO cobrancasPorCliente(String cpf) {
        String jpql = "SELECT new br.com.alura.srtch.dto.RelatorioDeCobrancasDTO ("
                + "c.divida.cliente.dadosPessoais.cpf, "
                + "COUNT(c)) "
                + "FROM Cobranca c WHERE c.divida.cliente.dadosPessoais.cpf = :cpf";
        return em.createQuery(jpql, RelatorioDeCobrancasDTO.class)
                .setParameter("cpf", cpf)
                .getSingleResult();
    }

    public List<Cobranca> buscarTodosPorTipoDeAcordo(TipoAcordo tipoAcordo) {
        String jpql = "SELECT c FROM Cobranca c WHERE c.tipoDeAcordo = :tipoDeAcordo";
        return em.createQuery(jpql, Cobranca.class)
                .setParameter("tipoDeAcordo", tipoAcordo)
                .getResultList();
    }

    public List<Cobranca> buscarTodos() {
        String jpql = "SELECT c FROM Cobranca c";
        return em.createQuery(jpql, Cobranca.class).getResultList();
    }

    public Cobranca buscarPorId(long id) {
        return em.find(Cobranca.class, id);
    }

    public void cadastrar(Cobranca cobranca){
        this.em.persist(cobranca);
    }

    public void atualizar(Cobranca cobranca) {
        this.em.merge(cobranca);
    }

    public void remover(Cobranca cobranca) {
        cobranca = em.merge(cobranca);
        this.em.remove(cobranca);
    }

}
