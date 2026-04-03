package com.sga.treino.exercicio.dto;

import jakarta.validation.constraints.NotBlank;

public record ExercicioRequestDTO(
    
    @NotBlank(message = "O nome do exercício é obrigatório")
    String nome,

    @NotBlank(message = "O grupo muscular é obrigatório")
    String grupoMuscular
) {}
