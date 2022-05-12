package br.com.alura.srtch.easycharge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.srtch.easycharge.modelo.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNome(String nome);

}