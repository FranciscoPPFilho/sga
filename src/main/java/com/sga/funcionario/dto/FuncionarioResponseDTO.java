package com.sga.funcionario.dto;

import com.sga.funcionario.Role;
import java.time.LocalDate;

public record FuncionarioResponseDTO(
    Long id,
    String nomeCompleto,
    String email,
    String telefone,
    String cargo,
    Role role,
    LocalDate dataContratacao,
    Boolean ativo
) {}