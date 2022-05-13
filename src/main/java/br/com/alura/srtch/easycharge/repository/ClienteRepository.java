package br.com.alura.srtch.easycharge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.alura.srtch.easycharge.modelo.Cliente;
import br.com.alura.srtch.easycharge.projection.RelatorioClientesProjection;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNome(String nome);
	
	
 
   @Query(value = "select cliente.nome AS nome, sum(divida.valor_da_divida) AS dividaValor, contagemCobrancas.contagem AS cobrancaContagem \n" +
    		            "    from cliente\n" +
    		            "    left join divida\n" +
    		            "         on  cliente.id=divida.cliente\n" +
    		            "    left join (\n" +
    		            "        select divida.cliente as clienteId, count(cobranca.id)  as contagem\n" +
    		            "            from cobranca\n" +
    		            "            inner join divida\n" +
    		            "                on divida.id=cobranca.divida_id\n" +
    		            "            group by divida.cliente\n" +
    		            "    ) as contagemCobrancas\n" +
    		            "        on contagemCobrancas.clienteId = cliente.id\n" +
    		            "    group by cliente.id",
    		            nativeQuery = true)
    
	List<RelatorioClientesProjection> ClienteDividas();
	

}