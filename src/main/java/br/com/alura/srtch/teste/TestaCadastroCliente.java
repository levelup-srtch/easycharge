package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.ClienteDAO;
import br.com.alura.srtch.modelo.*;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestaCadastroCliente {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        Cadastro cadastro = new Cadastro("(61)98651-7633", "gabrielandraad@gmail.com", StatusCliente.ATIVO);
        Endereco endereco = new Endereco("Avenida JK", "11", "Ponte Alta Norte", "Gama", "Distrito Federal");
        endereco.setComplemento("Condomínio Alvorada");
        Cliente cliente = new Cliente("05851040181", "Gabriel Andrade Almeida", "Programador", new BigDecimal("2000"), cadastro, endereco);

        em.getTransaction().begin();

        ClientesPorEstado clientesPorEstado = new ClientesPorEstado();
        ClienteDAO clienteDAO = new ClienteDAO(em);

        System.out.println(cliente);

    }

}
