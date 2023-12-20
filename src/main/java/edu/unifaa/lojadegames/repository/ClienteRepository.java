package edu.unifaa.lojadegames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.unifaa.lojadegames.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
