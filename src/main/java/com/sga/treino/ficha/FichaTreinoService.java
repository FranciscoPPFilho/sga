package com.sga.treino.ficha;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sga.aluno.Aluno;
import com.sga.aluno.AlunoRepository;
import com.sga.exception.RecursoNaoEncontradoException;
import com.sga.treino.exercicio.Exercicio;
import com.sga.treino.exercicio.ExercicioRepository;
import com.sga.treino.ficha.dto.FichaTreinoRequestDTO;
import com.sga.treino.ficha.dto.FichaTreinoResponseDTO;
import com.sga.treino.ficha.dto.ItemTreinoRequestDTO;
import com.sga.treino.ficha.mapper.FichaTreinoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FichaTreinoService {
    
    private final FichaRepository fichaTreinoRepository;
    private final AlunoRepository alunoRepository;
    private final ExercicioRepository exercicioRepository;
    private final FichaTreinoMapper fichaTreinoMapper;

    @Transactional
    public FichaTreinoResponseDTO salvar(FichaTreinoRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(dto.alunoId())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com id " + dto.alunoId() + " não encontrado"));

        FichaTreino ficha = new FichaTreino();
        ficha.setNome(dto.nome());
        ficha.setAluno(aluno);
        
        List<Long> idsExercicios = dto.itens().stream()
            .map(ItemTreinoRequestDTO::exercicioId)
            .toList();

        List<Exercicio> encontrados = exercicioRepository.findAllById(idsExercicios);

        if (encontrados.size() != idsExercicios.size()) {
            throw new RecursoNaoEncontradoException("Um ou mais exercícios não foram encontrados");
        }

        Map<Long, Exercicio> mapExercicios = encontrados.stream()
            .collect(Collectors.toMap(Exercicio::getId, exercicio -> exercicio));

            for (ItemTreinoRequestDTO itemDto : dto.itens()) {
            
                Exercicio exercicio = mapExercicios.get(itemDto.exercicioId());
                
                ItemTreino item = new ItemTreino();
                item.setExercicio(exercicio);
                item.setFaixaRepeticoes(itemDto.faixaRepeticoes());
                item.setQntdSeries(itemDto.qntdSeries());
                item.setFicha(ficha);
                ficha.getItens().add(item);
            }
        FichaTreino fichaSalva = fichaTreinoRepository.save(ficha);
        return fichaTreinoMapper.toDto(fichaSalva);
    }

    public List<FichaTreinoResponseDTO> listarTodos() {
        List<FichaTreino> lista = fichaTreinoRepository.findAll();
        return fichaTreinoMapper.toListDto(lista);
    }

    public FichaTreinoResponseDTO buscarPorId(Long id) {
        FichaTreino ficha = fichaTreinoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Ficha com o id " + id + " não encontrada"));
        return fichaTreinoMapper.toDto(ficha);
    }
}
