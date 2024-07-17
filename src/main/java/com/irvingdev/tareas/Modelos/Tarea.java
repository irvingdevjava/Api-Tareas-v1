package com.irvingdev.tareas.Modelos;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="TAREA")
public class Tarea implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(name = "fecha_inicio",nullable = false)
    private LocalDate FechaInicio;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Prioridad prioridad;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    public enum Prioridad{
        BAJA, MEDIA, ALTA
    }

    @PrePersist
    protected void onCreate() {
        if (this.FechaInicio == null) {
            this.FechaInicio = LocalDate.now();
        }}


}
