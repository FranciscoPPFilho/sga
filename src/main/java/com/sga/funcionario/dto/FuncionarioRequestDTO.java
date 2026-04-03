package com.sga.funcionario.dto;

import com.sga.funcionario.Role;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public record FuncionarioRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nomeCompleto,

    @NotBlank(message = "CPF é obrigatório")
    @org.hibernate.validator.constraints.br.CPF(message = "CPF inválido")
    String cpf,

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    String email,

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Mínimo de 6 caracteres")
    String senha,

    String telefone,
    
    @NotNull(message = "A data de contratação é obrigatória")
    LocalDate dataContratacao,

    @NotBlank(message = "O cargo é obrigatório")
    String cargo,

    @NotNull(message = "O nível de acesso (Role) é obrigatório")
    Role role,

    @NotNull(message = "O salário é obrigatório")
    @Positive(message = "O salário deve ser maior que zero")
    BigDecimal salario
) {}