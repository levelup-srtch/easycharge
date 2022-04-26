package br.com.alura.srtch.teste;

import br.com.alura.srtch.dao.*;
import br.com.alura.srtch.modelo.Cliente;
import br.com.alura.srtch.modelo.Divida;
import br.com.alura.srtch.modelo.StatusDivida;
import br.com.alura.srtch.service.ValidacaoTipoDoArquivo;
import br.com.alura.srtch.util.JPAUtil;
import br.com.alura.srtch.vo.ParseCliente;
import br.com.alura.srtch.vo.RecebeClienteDoArquivo;

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
        List<RecebeClienteDoArquivo> recebeClienteDoArquivos = new ValidacaoTipoDoArquivo().validaTipoDoArquivo(arquivo);
        List<Cliente> clientes = new ParseCliente().transformarEmCliente(recebeClienteDoArquivos);
        EntityManager em = JPAUtil.getEntityManager();

        dividas.add(new Divida(new BigDecimal("1550"), StatusDivida.ABERTA, clientes.get(0)));
        dividas.add(new Divida(new BigDecimal("543"), StatusDivida.ABERTA, clientes.get(0)));
        dividas.add(new Divida(new BigDecimal("150"), StatusDivida.ABERTA, clientes.get(1)));

        EnderecoDAO enderecoDAO = new EnderecoDAO(em);
        CadastroDAO cadastroDAO = new CadastroDAO(em);
        ClienteDAO clienteDAO = new ClienteDAO(em);
        DividaDAO dividaDAO = new DividaDAO(em);

        em.getTransaction().begin();

        for(Cliente cliente : clientes){
            cadastroDAO.cadastrar(cliente.getCadastro());
            enderecoDAO.cadastrar(cliente.getEndereco());
            clienteDAO.cadastrar(cliente);
        }

        for(Divida divida : dividas){
            dividaDAO.cadastrar(divida);
        }

        em.getTransaction().commit();
        em.close();
    }
}
