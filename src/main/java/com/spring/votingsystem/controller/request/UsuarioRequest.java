package com.spring.votingsystem.controller.request;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
    @NotNull
    private String idUsuario;
}
