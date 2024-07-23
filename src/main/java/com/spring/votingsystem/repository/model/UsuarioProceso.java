package com.spring.votingsystem.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario_proceso")
@Transactional
public class UsuarioProceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUP")
    private Long idUP;

    @Column(name = "estado_voto")
    private String estadoVoto;

    @NonNull
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proceso")
    @JsonIgnore
    private Proceso proceso;

    private String voto;
}