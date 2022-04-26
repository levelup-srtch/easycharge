package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.DadosPessoaisDAO;
import br.com.alura.srtch.dao.ClienteDAO;
import br.com.alura.srtch.dao.EnderecoDAO;
import br.com.alura.srtch.modelo.*;
import br.com.alura.srtch.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class TestaCadastroCliente {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        DadosPessoais cadastro = new DadosPessoais("(61)98651-7633", "gabrielandraad@gmail.com", StatusCliente.ATIVO);
        Endereco endereco = new Endereco("Avenida JK", "11", "Ponte Alta Norte", "Gama", "Distrito Federal");
        endereco.setComplemento("Condomínio Alvorada");
        Cliente cliente = new Cliente("05851040181", "Gabriel Andrade Almeida", "Programador", new BigDecimal("2000"), cadastro, endereco);

        ClienteDAO clienteDAO = new ClienteDAO(em);
        DadosPessoaisDAO cadastroDAO = new DadosPessoaisDAO(em);
        EnderecoDAO enderecoDAO = new EnderecoDAO(em);

        em.getTransaction().begin();

        cadastroDAO.cadastrar(cadastro);
        enderecoDAO.cadastrar(endereco);
        clienteDAO.cadastrar(cliente);

        clienteDAO.buscarPorNome("Gabriel Andrade Almeida");

        clienteDAO.buscarTodosPorStatus(StatusCliente.ATIVO);

        em.getTransaction().commit();
        em.close();

    }

}
