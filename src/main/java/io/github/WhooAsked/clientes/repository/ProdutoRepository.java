package io.github.WhooAsked.clientes.repository;

import io.github.WhooAsked.clientes.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}
