package io.github.WhooAsked.clientes.model.repository;

import io.github.WhooAsked.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
