package io.github.WhooAsked.clientes.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false, length = 250)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String Nome;

    @Column(nullable = false, length = 9)
    @NotNull(message = "{campo.cpf.obrigatorio}")
    private Integer CPF;


    @Column
    private BigDecimal valor;
}
