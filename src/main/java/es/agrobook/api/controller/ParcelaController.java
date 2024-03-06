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
import es.agrobook.api.model.location.ParcelaSigpac;
import es.agrobook.api.service.ParcelaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ParcelaController {

    private final ParcelaService parcelaService;




    @GetMapping("/parcelas/{id}")
    public ResponseEntity<Object> getParcela(@PathVariable Long id) {

        try{
            Optional<ParcelaSigpac> parcela = parcelaService.findById(id);
            if(parcela == null)
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            return ResponseEntity.ok(parcela.get());
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PostMapping("/parcela")
    public ResponseEntity<Object> crearParcela(@RequestBody ParcelaSigpac parcela) {
        
        try{
            ParcelaSigpac nuevaParcela = parcelaService.saveAndFlush(parcela);
            return ResponseEntity.ok(nuevaParcela);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    @PutMapping("/parcela")
    public ResponseEntity<Object> actualizaParcela(@RequestBody ParcelaSigpac parcela) {
        
        try{
            ParcelaSigpac nuevaParcela = parcelaService.saveAndFlush(parcela);
            return ResponseEntity.ok(nuevaParcela);
        }
        catch(Exception ex){
            return AgroBookApplication.handleControllerException(ex);
        }
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}