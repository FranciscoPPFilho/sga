package com.sga.aluno.dto;

import java.time.LocalDate;

public record AlunoResponseDTO(
    Long id,
    String nomeCompleto,
    String cpf,
    LocalDate dataNascimento,
    String email,
    String telefone,
    Boolean ativo
) {}