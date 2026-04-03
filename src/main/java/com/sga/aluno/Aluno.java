package com.sga.aluno;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sga.treino.ficha.FichaTreino;

@Entity
@Table(name = "alunos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    private LocalDate dataNascimento;

    @Column(unique = true)
    private String email;

    private String telefone;
    private String endereco;
    private String sexo;
    private Boolean ativo = true;

    @Column(columnDefinition = "TEXT")
    private String observacoes;
    
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FichaTreino> fichas = new ArrayList<>();
}

