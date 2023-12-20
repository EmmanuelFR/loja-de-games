package edu.unifaa.lojadegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.unifaa.lojadegames.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
