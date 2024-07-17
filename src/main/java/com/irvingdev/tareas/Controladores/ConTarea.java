package com.irvingdev.tareas.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irvingdev.tareas.Componentes.CTarea;
import com.irvingdev.tareas.Modelos.Tarea.Prioridad;


@RestController
@RequestMapping("/api/v1")
public class ConTarea {

    @Autowired
    private CTarea tareaf;

    @PostMapping("/tarea")
    public ResponseEntity<?> crearTarea(@RequestParam String titulo,
                                @RequestParam String descripcion, 
                                @RequestParam Boolean status,
                                @RequestParam Prioridad prioridad, 
                                @RequestParam Long idUsuario){
        
        return tareaf.crearTarea( titulo, descripcion, status, prioridad, idUsuario);
    }


    
}
