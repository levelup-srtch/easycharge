package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobrancaRepositori extends JpaRepository <Cobranca, Long> {

    boolean existsById(long id);

}
