package es.agrobook.api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.agrobook.api.AgroBookApplication;
import es.agrobook.api.model.Usuario;
import es.agrobook.api.model.explotacion.Explotacion;
import es.agrobook.api.model.persona.PersonaExplotacion;
import es.agrobook.api.service.ExplotacionService;
import es.agrobook.api.service.PersonaExplotacionService;
import es.agrobook.api.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PersonaExplotacionController {

    private final ExplotacionService explotacionService;
    private final PersonaExplotacionService personaExplotacionService;
    private final UsuarioService usuarioService;

    
    
    @GetMapping("/usuario-explotacion/{id}")
    public ResponseEntity<Object> getUsuariosExplotacion(@PathVariable Long id) {
        try{
            Explotacion explotacion = explotacionService.findById(id).get();
            if(explotacion == null)
                throw new EntityNotFoundException();

            //var usuarios = explotacion.getUsuariosExplotacion().stream().map(x -> x.getUsuario()).collect(Collectors.toSet()); // No funciona: getUsuariosExplotacion() devuelve un Set vacío
            var usuarios2 = personaExplotacionService.getPersonasExplotacion(explotacion);
            //var usuarios3 = personaExplotacionService.obtenerUsuariosDeExplotacion2(explotacion);
            return ResponseEntity.ok(usuarios2);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PutMapping("/usuario-explotacion/{id}")
    public ResponseEntity<Object> setUsuariosExplotacion(@PathVariable Long id, @RequestBody PersonaExplotacion.PersonaExplotacionId personaExplotacion) {
        try{
            if(personaExplotacion.getExplotacion() != id)
                throw new Exception("id de explotación obtenido del PathVariable no coincide con el id de explotación del RequestBody");

            Explotacion explotacion = explotacionService.findById(id).get();
            if(explotacion == null)
                throw new EntityNotFoundException();

            Usuario usuario = usuarioService.loadUserByUId(personaExplotacion.getPersona());
            PersonaExplotacion personaExplotacionRes = personaExplotacionService.asociarPersonaConExplotacion(usuario.getPersona(), explotacion, personaExplotacion.getRelacion());
                
            return ResponseEntity.ok(personaExplotacionRes);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @DeleteMapping("/usuario-explotacion/{id}")
    public ResponseEntity<Object> removeUsuariosExplotacion(@PathVariable Long id, @RequestBody PersonaExplotacion.PersonaExplotacionId personaExplotacion) {
        try{
            if(personaExplotacion.getExplotacion() != id)
                throw new Exception("id de explotación obtenido del PathVariable no coincide con el id de explotación del RequestBody");

            Explotacion explotacion = explotacionService.findById(id).get();
            if(explotacion == null)
                throw new EntityNotFoundException();

            Usuario usuario = usuarioService.loadUserByUId(personaExplotacion.getPersona());
            personaExplotacionService.eliminarAsociacion(usuario.getPersona(), explotacion, personaExplotacion.getRelacion());
                
            return ResponseEntity.ok("relación eliminada correctamente");
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}