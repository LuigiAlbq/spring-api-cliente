package io.github.WhooAsked.clientes.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 250)
    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;

    @Column(nullable = false, length = 9)
    @NotNull(message = "{campo.valor.obrigatorio}")
    private double valor;

    @Column(nullable = false, length = 250)
    @NotNull(message = "{campo.quantidade.obrigatorio}")
    private Integer quantidade;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDate.now());
    }

}
