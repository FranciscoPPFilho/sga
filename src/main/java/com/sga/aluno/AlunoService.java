package com.sga.aluno;

import java.util.List;
import org.springframework.stereotype.Service;

@Service // Essencial! Diz ao Spring que esta classe é um "Bean" de serviço
public class AlunoService {

    private final AlunoRepository alunoRepository;

    // Injeção de dependência via construtor (igual você fez no Controller)
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno salvar(Aluno aluno) {
        // Aqui no futuro colocaremos validações antes de salvar!
        return alunoRepository.save(aluno);
    }
}