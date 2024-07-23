package com.spring.votingsystem.controller.request;

import jakarta.persistence.Column;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PartyRequest {
    @NotNull
    private Long idPartido;

    @NotNull
    private String nombrePartido;

    @NotNull
    private String nombrePostulante;

    private Boolean imagenPartido;
}