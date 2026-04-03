package com.sga.funcionario.mapper;

import com.sga.funcionario.Funcionario;
import com.sga.funcionario.dto.FuncionarioRequestDTO;
import com.sga.funcionario.dto.FuncionarioResponseDTO;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    Funcionario toEntity(FuncionarioRequestDTO dto);

    FuncionarioResponseDTO toDto(Funcionario entity);

    List<FuncionarioResponseDTO> toDtoList(List<Funcionario> list);
}