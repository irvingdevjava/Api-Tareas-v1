package com.irvingdev.tareas.Modelos;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

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

    @Column(name = "fecha_terminado")
    private Date FechaTerminado;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Prioridad prioridad;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public enum Prioridad{
        BAJA, MEDIA, ALTA
    }


}
