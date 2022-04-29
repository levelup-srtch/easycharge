package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.*;
import br.com.alura.srtch.dto.RelatorioDeDividasDTO;
import br.com.alura.srtch.modelo.*;
import br.com.alura.srtch.service.TipoDoArquivo;
import br.com.alura.srtch.util.JPAUtil;
import br.com.alura.srtch.dto.ClienteMapper;
import br.com.alura.srtch.dto.ClienteDTO;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainCobrancaEDivida {
    public static void main(String[] args) {
        if (args.length <= 0) {
            throw new IllegalArgumentException("Forneça um nome de arquivo.");
        }
        String arquivo = args[0];

        List<Divida> dividas = new ArrayList<>();
        List<Cobranca> cobrancas = new ArrayList<>();
        List<ClienteDTO> recebeClienteDoArquivos = new TipoDoArquivo().validaTipoDoArquivo(arquivo);
        List<Cliente> clientes = new ClienteMapper().transformarEmCliente(recebeClienteDoArquivos);
        EntityManager em = JPAUtil.getEntityManager();

        dividas.add(new Divida(new BigDecimal("1550"), StatusDivida.ABERTA, clientes.get(0)));
        dividas.add(new Divida(new BigDecimal("543"), StatusDivida.ABERTA, clientes.get(0)));
        dividas.add(new Divida(new BigDecimal("150"), StatusDivida.ABERTA, clientes.get(1)));

        cobrancas.add(new Cobranca(MeioDeContato.EMAIL, "Joao pedro",
                TipoAgente.INTERNO, "Entrei em contato, mas nao respondeu",
                TipoAcordo.PROMESSA, "Pagara em 2 meses", dividas.get(0)));

        cobrancas.add(new Cobranca(MeioDeContato.TELEFONE, "Gabriel Almeida",
                TipoAgente.EXTERNO, "Por ter um bom creditScore liberei mais 1 mes",
                TipoAcordo.PROMESSA, "Pagara em mais 1 mes", dividas.get(0)));

        cobrancas.add(new Cobranca(MeioDeContato.TELEFONE, "Gabriel Almeida",
                TipoAgente.EXTERNO, "cliente quer parcelar em 13 vezes",
                TipoAcordo.PARCELAMENTO, "desconto da casa", dividas.get(0)));
        cobrancas.add(new Cobranca(MeioDeContato.EMAIL, "Flavia Coutinho",
                TipoAgente.EXTERNO, "Com mais 30 de atraso enviaremos seu nome pro serasa",
                TipoAcordo.PROMESSA, "sem acordo", dividas.get(1)));

        EnderecoDAO enderecoDAO = new EnderecoDAO(em);
        DadosPessoaisDAO cadastroDAO = new DadosPessoaisDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        DividaDAO dividaDAO = new DividaDAO(em);
        CobrancaDAO cobrancaDAO = new CobrancaDAO(em);

        em.getTransaction().begin();

        System.out.println("# Criando clientes");
        for (Cliente cliente : clientes) {
            cadastroDAO.cadastrar(cliente.getDadosPessoais());
            enderecoDAO.cadastrar(cliente.getEndereco());
            clienteDAO.cadastrar(cliente);
        }

        System.out.println(clientes.size() + " Clientes criados!");

        System.out.println("\n# Criando Dividas");
        for (Divida divida : dividas) {
            dividaDAO.cadastrar(divida);
        }

        System.out.println("\n# Criando Cobranças");
        for (Cobranca cobranca : cobrancas) {
            cobrancaDAO.cadastrar(cobranca);
        }

        System.out.println("\n# Atualizando divida para quitada");
        dividas.get(1).setStatus(StatusDivida.QUITADA);

        System.out.println("# Removendo divida");
        dividaDAO.remover(dividas.get(1).getId());

        em.getTransaction().commit();

        System.out.println(dividaDAO.buscarTodos());

        System.out.println(dividaDAO.buscarDividasSemCobranca());

        System.out.println(cobrancaDAO.buscarTodosPorTipoDeAcordo(TipoAcordo.PROMESSA));

        System.out.println(cobrancaDAO.somarNumeroDeCobrancas(clientes.get(0).getIdCliente()));

        List<RelatorioDeDividasDTO> relatorioDeDividas = dividaDAO.totalDeDividasECobrancas();
        System.out.println(relatorioDeDividas);

        em.close();


    }
}
