package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.Cobranca;
import br.com.alura.strch.dominio.Divida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CobrancaRepositori extends JpaRepository <Cobranca, Long> {

    boolean existsById(long id);
    boolean existsByDivida(Divida divida);
    List<Cobranca> getAllByDivida(Divida divida);

}
