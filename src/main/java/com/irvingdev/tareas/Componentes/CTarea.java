package com.irvingdev.tareas.Componentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.irvingdev.tareas.Modelos.Tarea;
import com.irvingdev.tareas.Modelos.Tarea.Prioridad;
import com.irvingdev.tareas.Modelos.Usuario;
import com.irvingdev.tareas.Respositorios.ITarea;
import com.irvingdev.tareas.Respositorios.IUsuario;

@Component
public class CTarea {
    @Autowired
    private ITarea tareaf;
    @Autowired
    private IUsuario usuariof;

    public ResponseEntity<?> crearTarea(
            String titulo,
            String descripcion,
            Boolean status,
            Prioridad prioridad,
            Long idUsuario) {

        try {
            Usuario usuario=usuariof.findById(idUsuario).orElse(null);
            if (usuario!=null) {
                Tarea tarea = Tarea.builder()
                        .titulo(titulo)
                        .descripcion(descripcion)
                        .status(status)
                        .prioridad(prioridad)
                        .usuario(usuario)
                        .build();
                tareaf.save(tarea);
                return ResponseEntity.status(HttpStatus.CREATED).body(tareaf.save(tarea));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Todos los campos son requeridos");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<?> eliminarTarea(Long id) {
        tareaf.deleteById(id);
        return null;
    }

}
