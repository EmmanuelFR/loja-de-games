package edu.unifaa.lojadegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unifaa.lojadegames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

} 