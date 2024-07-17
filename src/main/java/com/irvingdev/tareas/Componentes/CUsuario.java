package com.irvingdev.tareas.Componentes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.irvingdev.tareas.Modelos.Usuario;
import com.irvingdev.tareas.Respositorios.IUsuario;

import jakarta.transaction.Transactional;

@Component
public class CUsuario {
    @Autowired
    private IUsuario usuariof;

    @Transactional
    
    public ResponseEntity<?> crearUsuario(String nombre, String email) {
        try {
            // Verificar si el usuario ya existe por email
            Usuario usuarioExistente = usuariof.findByEmail(email);

            if (usuarioExistente != null) {
                // Si el usuario existe, actualizar sus datos
                usuarioExistente.setNombre(nombre);
                Usuario usuarioActualizado = usuariof.save(usuarioExistente);
                return ResponseEntity.status(HttpStatus.OK).body(usuarioActualizado);
            } else {
                // Si el usuario no existe, crear uno nuevo
                Usuario nuevoUsuario = Usuario.builder()
                        .nombre(nombre)
                        .email(email)
                        .build();
                Usuario usuarioCreado = usuariof.save(nuevoUsuario);
                return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity<?> usuarios(){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuariof.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }

    @Transactional
    public ResponseEntity<?> encontrarUsuario(Long id){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuariof.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }

    @Transactional
    public ResponseEntity<?> eliminarUsuario(Long id){
        try {
            usuariof.deleteById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario eliminado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }

    @Transactional
    public ResponseEntity<?> findEmail(String email){
        try {
            Usuario usuario=usuariof.findByEmail(email);
            if (usuario!=null) {
                return ResponseEntity.status(HttpStatus.OK).body(usuario);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
           
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        
    }


}
