package com.sga.aluno.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record AlunoRequestDTO(
    @NotBlank(message = "Nome é obrigatório")
    String nomeCompleto,

    @NotBlank(message = "CPF é obrigatório")
    @org.hibernate.validator.constraints.br.CPF(message = "CPF inválido")
    String cpf,

    @Past(message = "Data de nascimento deve ser no passado")
    LocalDate dataNascimento,

    @Email(message = "E-mail inválido")
    String email,

    String telefone,
    String endereco,
    String sexo,
    String observacoes
) {}