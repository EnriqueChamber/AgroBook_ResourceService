package es.agrobook.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.agrobook.api.model.Usuario;
import es.agrobook.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> obtenerTodosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodosUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/usuario/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRes = usuarioService.registrar(usuario);
        return ResponseEntity.ok(usuarioRes);
    }

    @GetMapping("/login")
    public ResponseEntity logIn() {
        
        Usuario usuarioRes = usuarioService.getLoggedInUser();

        if(usuarioRes == null)
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Usuario o contraseña incorrecta");

        if(!usuarioRes.isEnabled())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Cuenta desactivada");

        return ResponseEntity.ok(usuarioRes);
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}