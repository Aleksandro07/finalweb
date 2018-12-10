package br.com.ufc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ufc.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {



}
