package com.sga.treino.ficha.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.sga.treino.ficha.FichaTreino;
import com.sga.treino.ficha.ItemTreino;
import com.sga.treino.ficha.dto.FichaTreinoRequestDTO;
import com.sga.treino.ficha.dto.FichaTreinoResponseDTO;
import com.sga.treino.ficha.dto.ItemTreinoResponseDTO;

@Mapper(componentModel = "spring")
public interface FichaTreinoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "aluno", ignore = true)
    @Mapping(target = "itens", ignore = true)
    FichaTreino toEntity(FichaTreinoRequestDTO dto);

    @Mapping(target = "nomeAluno", source = "aluno.nomeCompleto")
    FichaTreinoResponseDTO toDto(FichaTreino entity);

    // Ensinamos como converter cada item da lista (ItemTreino -> ItemTreinoResponseDTO)
    @Mapping(target = "nomeExercicio", source = "exercicio.nome")
    @Mapping(target = "grupoMuscular", source = "exercicio.grupoMuscular")
    ItemTreinoResponseDTO toItemDto(ItemTreino item);

    List<FichaTreinoResponseDTO> toListDto(List<FichaTreino> lista);
}