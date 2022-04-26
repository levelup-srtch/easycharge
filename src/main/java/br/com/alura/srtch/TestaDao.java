package br.com.alura.srtch;

import javax.persistence.EntityManager;

import br.com.alura.srtch.dao.ClienteDao;
import br.com.alura.srtch.dao.CobrancaDao;
import br.com.alura.srtch.util.JPAUtil;

public class TestaDao {

	public static void main(String[] args) {
		  
		  EntityManager em = JPAUtil.getEntityManager();
		  ClienteDao clienteDao = new ClienteDao(em);
		  CobrancaDao cobrancaDao = new CobrancaDao(em);

	}

}
