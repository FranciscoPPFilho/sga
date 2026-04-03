package com.sga.treino.ficha;

import java.util.ArrayList;
import java.util.List;
import com.sga.aluno.Aluno;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ficha_treino")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class FichaTreino {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemTreino> itens = new ArrayList<>();
}
