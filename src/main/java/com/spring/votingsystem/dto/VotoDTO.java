package com.spring.votingsystem.dto;

// email del usuario que vota, id del proceso en el que vota y el voto que emite
public record VotoDTO(String email, Long idProceso, String voto) {
}
