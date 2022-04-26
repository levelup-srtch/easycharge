package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.*;
import br.com.alura.srtch.modelo.*;
import br.com.alura.srtch.util.JPAUtil;
import br.com.alura.srtch.vo.RelatorioDeCobrancas;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class TestaCobranca {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();

        Endereco endereco = new Endereco("21", "77", "vizenso", "jukso", "sjkak");
        Cadastro cadastro = new Cadastro("1299212918", "gg@gmaoi.com", StatusCliente.ATIVO);
        Cliente cliente = new Cliente("1291221", "OISAL", "dsafaask", new BigDecimal("7000"), cadastro, endereco);
        Divida divida = new Divida(new BigDecimal("3000"), LocalDate.now(), StatusDivida.ABERTA, cliente);
        Cobranca cobranca = new Cobranca(FormaDeContato.EMAIL, "Gabriel Almeida", TipoAgente.INTERNO, "teste", divida);

        EnderecoDAO enderecoDAO = new EnderecoDAO(em);
        CadastroDAO cadastroDAO = new CadastroDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        DividaDAO dividaDAO = new DividaDAO(em);
        CobrancaDAO cobrancaDAO = new CobrancaDAO(em);

        em.getTransaction().begin();

        cadastroDAO.cadastrar(cadastro);
        enderecoDAO.cadastrar(endereco);
        clienteDAO.cadastrar(cliente);
        dividaDAO.cadastrar(divida);
        cobrancaDAO.cadastrar(cobranca);

        System.out.println(divida);
        BigDecimal somaDividas = dividaDAO.somaDividasDoCliente("1291221");
        System.out.println("Soma das dividas: " + somaDividas);

        List<RelatorioDeCobrancas> numeroDeCobrancas = cobrancaDAO.cobrancasPorCliente("1291221");
        System.out.println(numeroDeCobrancas);

        em.getTransaction().commit();
        em.close();

    }
}
