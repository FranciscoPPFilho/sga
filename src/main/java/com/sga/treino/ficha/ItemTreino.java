package com.sga.treino.ficha;

import com.sga.treino.exercicio.Exercicio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ficha_id")
    private FichaTreino ficha;

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;
    
    @Column(nullable = false)
    private int qntdSeries;

    @Column(nullable = false)
    private String faixaRepeticoes;
}
