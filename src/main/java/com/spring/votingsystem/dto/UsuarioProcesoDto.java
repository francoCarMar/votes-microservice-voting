package com.spring.votingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioProcesoDto {
    private Long idUP;
    private String estadoVoto;
    private String idUsuario;
    private String idProceso;
}