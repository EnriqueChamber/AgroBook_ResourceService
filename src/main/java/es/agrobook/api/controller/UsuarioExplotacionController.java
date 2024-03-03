package es.agrobook.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.agrobook.api.AgroBookApplication;
import es.agrobook.api.model.Explotacion;
import es.agrobook.api.model.Usuario;
import es.agrobook.api.model.UsuarioExplotacion;
import es.agrobook.api.model.UsuarioExplotacionId;
import es.agrobook.api.service.ExplotacionService;
import es.agrobook.api.service.UsuarioExplotacionService;
import es.agrobook.api.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioExplotacionController {

    private final ExplotacionService explotacionService;
    private final UsuarioExplotacionService usuarioExplotacionService;
    private final UsuarioService usuarioService;

    
    
    @GetMapping("/usuario-explotacion/{id}")
    public ResponseEntity<Object> getUsuariosExplotacion(@PathVariable Long id) {
        try{
            Explotacion explotacion = explotacionService.findById(id).get();
            if(explotacion == null)
                throw new EntityNotFoundException();

            //var usuarios = explotacion.getUsuariosExplotacion().stream().map(x -> x.getUsuario()).collect(Collectors.toSet()); // No funciona: getUsuariosExplotacion() devuelve un Set vacío
            var usuarios2 = usuarioExplotacionService.getUsuariosExplotacion(explotacion);
            //var usuarios3 = usuarioExplotacionService.obtenerUsuariosDeExplotacion2(explotacion);
            return ResponseEntity.ok(usuarios2);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PutMapping("/usuario-explotacion/{id}")
    public ResponseEntity<Object> setUsuariosExplotacion(@PathVariable Long id, @RequestBody UsuarioExplotacionId usuarioExplotacion) {
        try{
            if(usuarioExplotacion.getExplotacion() != id)
                throw new Exception("id de explotación obtenido del PathVariable no coincide con el id de explotación del RequestBody");

            Explotacion explotacion = explotacionService.findById(id).get();
            if(explotacion == null)
                throw new EntityNotFoundException();

            Usuario usuario = usuarioService.loadUserByUId(usuarioExplotacion.getUsuario());
            UsuarioExplotacion usuarioExplotacionRes = usuarioExplotacionService.asociarUsuarioConExplotacion(usuario, explotacion, usuarioExplotacion.getRelacion());
                
            return ResponseEntity.ok(usuarioExplotacionRes);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @DeleteMapping("/usuario-explotacion/{id}")
    public ResponseEntity<Object> removeUsuariosExplotacion(@PathVariable Long id, @RequestBody UsuarioExplotacionId usuarioExplotacion) {
        try{
            if(usuarioExplotacion.getExplotacion() != id)
                throw new Exception("id de explotación obtenido del PathVariable no coincide con el id de explotación del RequestBody");

            Explotacion explotacion = explotacionService.findById(id).get();
            if(explotacion == null)
                throw new EntityNotFoundException();

            Usuario usuario = usuarioService.loadUserByUId(usuarioExplotacion.getUsuario());
            usuarioExplotacionService.eliminarAsociacion(usuario, explotacion, usuarioExplotacion.getRelacion());
                
            return ResponseEntity.ok("relación eliminada correctamente");
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}