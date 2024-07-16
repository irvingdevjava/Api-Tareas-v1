package com.irvingdev.tareas.Respositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irvingdev.tareas.Modelos.Tarea;

public interface ITarea extends JpaRepository<Tarea, Long> {

}
