package com.sga.aluno;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sga.aluno.dto.AlunoRequestDTO;
import com.sga.aluno.dto.AlunoResponseDTO;
import com.sga.aluno.mapper.AlunoMapper;
import com.sga.exception.RecursoNaoEncontradoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final AlunoMapper alunoMapper;

    public AlunoResponseDTO salvar(AlunoRequestDTO dto) {
            Aluno aluno = alunoMapper.toEntity(dto);
            Aluno alunoSalvo = alunoRepository.save(aluno);
            return alunoMapper.toDto(alunoSalvo);
    }
    
    public List<AlunoResponseDTO> listarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunoMapper.toDtoList(alunos);
    }
    
    public AlunoResponseDTO buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com id " + id + " não encontrado"));
        return alunoMapper.toDto(aluno);
    }
    
}