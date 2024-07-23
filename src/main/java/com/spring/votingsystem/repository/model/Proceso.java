package com.spring.votingsystem.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.transaction.Transactional;
import lombok.*;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "proceso")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Transactional
public class Proceso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proceso")
    private Long idProceso;

    @Column(name = "nombre_proceso")
    private String nombreProceso;

    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;

    @Column(name = "fecha_fin")
    private Timestamp fechaFin;

    @Column(name = "tiempo_espera")
    private Integer tiempoEspera;

    @Column(name = "estado_proceso")
    private String estadoProceso;

    @OneToMany(mappedBy = "proceso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UsuarioProceso> usuarioProceso;

    @OneToMany(mappedBy = "proceso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Partido> partidoProceso;

    @Column(name = "email_admin")
    private String emailAdmin;
}