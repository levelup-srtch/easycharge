package br.com.alura.srtch.repository;

import br.com.alura.srtch.model.Cliente;
import br.com.alura.srtch.projection.RelatorioClientesProjecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByDadosPessoaisNome(String nome);

    @Query(value = "select cliente.nome as nome, sum(divida.valor) as dividaValor, contagemCobrancas.contagem as cobrancaContagem\n" +
            "    from cliente\n" +
            "    left join divida\n" +
            "         on  cliente.id=divida.cliente_id\n" +
            "    left join (\n" +
            "        select divida.cliente_id as clienteId, count(cobranca.id)  as contagem\n" +
            "            from cobranca\n" +
            "            inner join divida\n" +
            "                on divida.id=cobranca.divida_id\n" +
            "            group by divida.cliente_id\n" +
            "    ) as contagemCobrancas\n" +
            "        on contagemCobrancas.clienteId = cliente.id\n" +
            "    group by cliente.id",
            nativeQuery = true)
    List<RelatorioClientesProjecao> findNomeValorDasDividasCobrancas();


}
