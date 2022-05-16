package br.com.alura.srtch.repository;

import br.com.alura.srtch.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {

    @Query("SELECT SUM(d.valor) FROM Divida d "
            + "WHERE d.status = 'ABERTA' "
            + "AND d.cliente.id = :id")
    BigDecimal buscaSomaDoValorDaDivida(@Param("id") Long idCliente);

}
