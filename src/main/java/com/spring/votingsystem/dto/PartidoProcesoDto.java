package com.spring.votingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartidoProcesoDto {
    private Long idPP;
    private String estadoPartido;
    private String idPartido;
    private String idProceso;
}