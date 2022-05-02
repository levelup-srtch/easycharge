package br.com.alura.strch.repositorio;

import br.com.alura.strch.dominio.Cliente;
import br.com.alura.strch.dominio.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DividaRepositorio extends JpaRepository <Divida, Long>, JpaSpecificationExecutor<Divida> {

    boolean existsByDivida (Long id);
    boolean existsByDataAbertura (LocalDate data);
    boolean existsByCliente (Cliente cliente);

    @Query("SELECT obj FROM Divida obj order by obj.dataAbertura")
    List<Divida> OrederByDate();

    List<Divida> getAllByCliente(Cliente cliente);

}
