package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
