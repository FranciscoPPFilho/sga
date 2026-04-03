package com.sga.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErroResposta(
    LocalDateTime timestamp,
    Integer status,
    String erro,
    String mensagem,
    String path,
    List<CampoComErro> campos
) {
    public record CampoComErro(String campo, String mensagem) {}
}