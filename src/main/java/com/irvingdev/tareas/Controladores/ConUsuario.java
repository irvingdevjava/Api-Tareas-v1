package com.irvingdev.tareas.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irvingdev.tareas.Componentes.CUsuario;



@RestController
@RequestMapping("/api/v1")
public class ConUsuario {
    @Autowired
    private CUsuario usuariof;
    
    @PostMapping("/usuario")
    public ResponseEntity<?> crearUsuario(@RequestParam String nombre,
                                        @RequestParam String email){
        return usuariof.crearUsuario(nombre, email);
        
    }

    @GetMapping("/usuario/{email}")
    public ResponseEntity<?> finByEmail(@PathVariable String email) {
        return usuariof.findEmail(email);
    }

    @GetMapping("/usuarios")
    public ResponseEntity<?> usuarios() {
        return usuariof.usuarios();
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return usuariof.encontrarUsuario(id);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> removeById(@PathVariable Long id) {
        return usuariof.encontrarUsuario(id);
    }
    
    
}
