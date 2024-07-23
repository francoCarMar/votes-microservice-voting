package com.spring.votingsystem.repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Proceso proceso;

    private Long idPartido;
}