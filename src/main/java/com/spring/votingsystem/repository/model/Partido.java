package com.spring.votingsystem.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

@Data
@Entity
@Table(name = "partido")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Transactional
public class Partido {
    @Id
    @Column(name = "id_partido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPartido;

    @Column(name = "nombre_partido")
    private String nombrePartido;

    @Column(name = "nombre_postulante")
    private String nombrePostulante;

    @Column(name = "imagen_partido")
    private Boolean imagenPartido;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proceso")
    @JsonIgnore
    private Proceso proceso;
}