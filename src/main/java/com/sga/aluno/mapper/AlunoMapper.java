package com.sga.aluno.mapper;

import com.sga.aluno.Aluno;
import com.sga.aluno.dto.AlunoRequestDTO;
import com.sga.aluno.dto.AlunoResponseDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "fichas", ignore = true)
    Aluno toEntity(AlunoRequestDTO dto);

    AlunoResponseDTO toDto(Aluno entity);

    List<AlunoResponseDTO> toDtoList(List<Aluno> alunos);
}