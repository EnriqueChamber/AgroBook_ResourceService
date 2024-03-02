package es.agrobook.api.controller;

import java.util.List;
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

import es.agrobook.api.model.Parcela;
import es.agrobook.api.service.ParcelaService;

@RestController
@RequestMapping("/api")
public class ParcelaController {

    @Autowired
    private ParcelaService parcelaService;


    @GetMapping("/parcelas/{id}")
    public ResponseEntity<Parcela> getParcela(@PathVariable Long id) {
        Optional<Parcela> parcela = parcelaService.findById(id);
        if(parcela == null)
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(parcela.get());
    }

    @PostMapping("/parcela")
    public ResponseEntity<Parcela> crearParcela(@RequestBody Parcela parcela) {
        Parcela nuevaParcela = parcelaService.saveAndFlush(parcela);
        return ResponseEntity.ok(nuevaParcela);
    }

    @PutMapping("/parcela")
    public ResponseEntity<Parcela> actualizaParcela(@RequestBody Parcela parcela) {
        Parcela nuevaParcela = parcelaService.saveAndFlush(parcela);
        return ResponseEntity.ok(nuevaParcela);
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}