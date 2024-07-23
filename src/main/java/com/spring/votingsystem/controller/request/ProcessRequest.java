package com.spring.votingsystem.controller.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.votingsystem.repository.model.Partido;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProcessRequest {
    private Long idProceso;

    @NotNull
    private String nombreProceso;

    @NotNull
    private Timestamp fechaInicio;

    @NotNull
    private Timestamp fechaFin;

    @NotNull
    private Integer tiempoEspera;

    @NotNull
    private String estadoProceso;

    @NotNull
    private String emailAdmin;

    @NotNull
    private List<Partido> partidos;

    public static ProcessRequest fromJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, ProcessRequest.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}