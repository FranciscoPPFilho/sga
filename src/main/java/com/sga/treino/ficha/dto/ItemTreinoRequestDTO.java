package com.sga.treino.ficha.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemTreinoRequestDTO(
    @NotNull(message = "O ID do exercício é obrigatório")
    Long exercicioId,
    
    @Positive(message = "A quantidade de séries deve ser maior que zero")
    int qntdSeries,
    
    @NotBlank(message = "A faixa de repetições é obrigatória (ex: 10 a 12)")
    String faixaRepeticoes
) {}