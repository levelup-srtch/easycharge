package br.com.alura.srtch.service;

import br.com.alura.srtch.dao.CobrancaDAO;
import br.com.alura.srtch.modelo.Cobranca;

import javax.persistence.EntityManager;

public class CobrancasDaDivida {

    public static void removerCobrancas(Long id, EntityManager em){
        CobrancaDAO cobrancaDAO = new CobrancaDAO(em);
        for(Cobranca cobranca : cobrancaDAO.buscarCobrancasDaDivida(id)){
            cobrancaDAO.remover(cobranca);
        }
    }
}
