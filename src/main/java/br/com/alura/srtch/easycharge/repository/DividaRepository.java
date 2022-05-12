package br.com.alura.srtch.easycharge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.srtch.easycharge.modelo.Divida;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {

}