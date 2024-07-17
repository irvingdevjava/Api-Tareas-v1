package com.irvingdev.tareas.Respositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irvingdev.tareas.Modelos.Usuario;


public interface IUsuario extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}

