package com.sga.treino.ficha;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sga.treino.ficha.dto.FichaTreinoRequestDTO;
import com.sga.treino.ficha.dto.FichaTreinoResponseDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/ficha-treino")
@RequiredArgsConstructor
public class FichaTreinoController {
    
    private final FichaTreinoService fichaTreinoService;

    @PostMapping
    public ResponseEntity<FichaTreinoResponseDTO> cadastrar(@RequestBody @Valid FichaTreinoRequestDTO dto) {
        FichaTreinoResponseDTO response = fichaTreinoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FichaTreinoResponseDTO>> listarTodos() {
        List<FichaTreinoResponseDTO> response = fichaTreinoService.listarTodos();
        return ResponseEntity.ok(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<FichaTreinoResponseDTO> buscarPorId(@PathVariable Long id) {
        FichaTreinoResponseDTO response = fichaTreinoService.buscarPorId(id);
        return ResponseEntity.ok(response);
    }
}
