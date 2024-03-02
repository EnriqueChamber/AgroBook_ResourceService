package es.agrobook.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.service.ExplotacionService;

@RestController
@RequestMapping("/api")
public class ExplotacionController {

    @Autowired
    private ExplotacionService explotacionService;

    @GetMapping("/explotaciones")
    public ResponseEntity<Object> getExplotaciones() {
        try{
            List<Explotacion> explotaciones = explotacionService.getExplotaciones();
            return ResponseEntity.ok(explotaciones);
        }
        catch(Exception ex){
            return handleException(ex);
        }
    }


    @GetMapping("/explotaciones/{id}")
    public ResponseEntity<Object> getExplotacion(@PathVariable Long id) {
        try{
            Optional<Explotacion> explotacion = explotacionService.findById(id);
            if(explotacion == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.ok(explotacion.get());
        }
        catch(Exception ex){
            return handleException(ex);
        }
    }

    @PostMapping("/explotacion")
    public ResponseEntity<Object> crearExplotacion(@RequestBody Explotacion explotacion) {
        try{
            Explotacion nuevaExplotacion = explotacionService.saveAndFlush(explotacion);
            return ResponseEntity.ok(nuevaExplotacion);
        }
        catch(Exception ex){
            return handleException(ex);
        }
    }

    @PutMapping("/explotacion")
    public ResponseEntity<Object> actualizaExplotacion(@RequestBody Explotacion explotacion) {
        try{
            Explotacion explotacionModificada = explotacionService.saveAndFlush(explotacion);
            return ResponseEntity.ok(explotacionModificada);
        }
        catch(Exception ex){
            return handleException(ex);
        }
    }


    private ResponseEntity<Object> handleException(Exception ex){

        if(ex instanceof DataIntegrityViolationException){
            DataIntegrityViolationException exception = (DataIntegrityViolationException)ex;
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        
        
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}