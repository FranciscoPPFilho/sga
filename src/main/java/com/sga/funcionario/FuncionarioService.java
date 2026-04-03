package com.sga.funcionario;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sga.exception.RecursoNaoEncontradoException;
import com.sga.funcionario.dto.FuncionarioRequestDTO;
import com.sga.funcionario.dto.FuncionarioResponseDTO;
import com.sga.funcionario.mapper.FuncionarioMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioResponseDTO salvar(FuncionarioRequestDTO dto) {
        Funcionario funcionario = funcionarioMapper.toEntity(dto);
        Funcionario novoFuncionario = funcionarioRepository.save(funcionario);
        return funcionarioMapper.toDto(novoFuncionario);
    }
    
    public List<FuncionarioResponseDTO> listarTodos() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarioMapper.toDtoList(funcionarios);
    }

    public FuncionarioResponseDTO buscarPorId(Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Aluno com id " + id + " não encontrado"));
        return funcionarioMapper.toDto(funcionario);
    }

}
