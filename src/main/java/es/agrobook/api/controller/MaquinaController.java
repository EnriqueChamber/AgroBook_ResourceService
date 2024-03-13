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
import es.agrobook.api.model.maquina.Maquina;
import es.agrobook.api.service.MaquinaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MaquinaController {

    private final MaquinaService maquinaService;




    @GetMapping("/maquinas/{id}")
    public ResponseEntity<Object> getMaquina(@PathVariable Long id) {

        try{
            Optional<Maquina> maquina = maquinaService.findById(id);
            if(maquina == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.ok(maquina.get());
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PostMapping("/maquina")
    public ResponseEntity<Object> crearMaquina(@RequestBody Maquina maquina) {
        
        try{
            Maquina nuevaMaquina = maquinaService.saveAndFlush(maquina);
            return ResponseEntity.ok(nuevaMaquina);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PutMapping("/maquina")
    public ResponseEntity<Object> actualizaMaquina(@RequestBody Maquina maquina) {
        
        try{
            Maquina nuevaMaquina = maquinaService.saveAndFlush(maquina);
            return ResponseEntity.ok(nuevaMaquina);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}