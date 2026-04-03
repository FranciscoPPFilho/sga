package com.sga.treino.ficha.dto;

import java.util.List;

public record FichaTreinoResponseDTO(
    Long id,
    String nome,
    String nomeAluno, // Simplificamos: apenas o nome para o cabeçalho da ficha
    List<ItemTreinoResponseDTO> itens
) {}
