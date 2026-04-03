package com.sga.treino.ficha.dto;

public record ItemTreinoResponseDTO(
    String nomeExercicio,
    String grupoMuscular,
    int qntdSeries,
    String faixaRepeticoes
) {}
