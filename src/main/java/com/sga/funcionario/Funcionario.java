package com.sga.funcionario;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email; // Será o nosso "username" no login

    @Column(nullable = false)
    private String senha; // Guardaremos a senha aqui

    private String telefone;

    private LocalDate dataContratacao;

    private Boolean ativo = true;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

    @Column(precision = 10, scale = 2)
    private BigDecimal salario;

}