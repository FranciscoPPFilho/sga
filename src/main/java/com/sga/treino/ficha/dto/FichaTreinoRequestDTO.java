package com.sga.treino.ficha.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public record FichaTreinoRequestDTO(
    @NotBlank(message = "O nome da ficha é obrigatório")
    String nome,
    
    @NotNull(message = "O ID do aluno é obrigatório")
    Long alunoId,
    
    @NotEmpty(message = "A ficha deve conter pelo menos um exercício")
    @Valid
    List<ItemTreinoRequestDTO> itens
) {}