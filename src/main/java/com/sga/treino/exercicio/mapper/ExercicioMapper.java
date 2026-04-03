package com.sga.treino.exercicio.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sga.treino.exercicio.Exercicio;
import com.sga.treino.exercicio.dto.ExercicioRequestDTO;
import com.sga.treino.exercicio.dto.ExercicioResponseDTO;

@Mapper(componentModel = "spring")
public interface ExercicioMapper {
    
    @Mapping(target = "id", ignore = true)
    Exercicio toEntity(ExercicioRequestDTO dto);

    ExercicioResponseDTO toDto(Exercicio entity);

    List<ExercicioResponseDTO> toListDto(List<Exercicio> exercicios);
}
