package com.sga.treino.exercicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sga.exception.RecursoNaoEncontradoException;
import com.sga.treino.exercicio.dto.ExercicioRequestDTO;
import com.sga.treino.exercicio.dto.ExercicioResponseDTO;
import com.sga.treino.exercicio.mapper.ExercicioMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExercicioService {
    
    private final ExercicioRepository exercicioRepository;
    private final ExercicioMapper exercicioMapper;

    public ExercicioResponseDTO salvar(ExercicioRequestDTO dto) {
        Exercicio exercicio = exercicioMapper.toEntity(dto);
        Exercicio exercicioSalvo = exercicioRepository.save(exercicio);
        return exercicioMapper.toDto(exercicioSalvo);
    }

    public List<ExercicioResponseDTO> listarTodos() {
        List<Exercicio> lista = exercicioRepository.findAll();
        return exercicioMapper.toListDto(lista);
    }

    public ExercicioResponseDTO buscarPorId(Long id) {
        Exercicio exercicio = exercicioRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Exercicio com id " + id + " não encontrado"));
        return exercicioMapper.toDto(exercicio);
    }
}
