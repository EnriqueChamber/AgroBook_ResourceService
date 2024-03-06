package es.agrobook.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.agrobook.api.AgroBookApplication;
import es.agrobook.api.model.cultivo.Cultivo;
import es.agrobook.api.service.CultivoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CultivoController {

    private final CultivoService cultivoService;




    @GetMapping("/cultivos/{id}")
    public ResponseEntity<Object> getCultivo(@PathVariable Long id) {

        try{
            Optional<Cultivo> cultivo = cultivoService.findById(id);
            if(cultivo == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.ok(cultivo.get());
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PostMapping("/cultivo")
    public ResponseEntity<Object> crearCultivo(@RequestBody Cultivo cultivo) {
        
        try{
            Cultivo nuevaCultivo = cultivoService.saveAndFlush(cultivo);
            return ResponseEntity.ok(nuevaCultivo);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PutMapping("/cultivo")
    public ResponseEntity<Object> actualizaCultivo(@RequestBody Cultivo cultivo) {
        
        try{
            Cultivo nuevaCultivo = cultivoService.saveAndFlush(cultivo);
            return ResponseEntity.ok(nuevaCultivo);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}