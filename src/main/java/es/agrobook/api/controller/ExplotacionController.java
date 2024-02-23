package es.agrobook.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.agrobook.api.model.Explotacion;
import es.agrobook.api.service.ExplotacionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ExplotacionController {

    @Autowired
    private ExplotacionService explotacionService;

    @GetMapping("/explotaciones")
    public ResponseEntity<List<Explotacion>> getExplotaciones() {
        List<Explotacion> explotaciones = explotacionService.getExplotaciones();
        return ResponseEntity.ok(explotaciones);
    }

    @GetMapping("/explotacion/{id}")
    public ResponseEntity<Explotacion> crearExplotacion(@PathVariable Long id) {
        Optional<Explotacion> explotacion = explotacionService.findById(id);
        if(explotacion == null)
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(explotacion.get());
    }

    @PostMapping("/explotacion")
    @PutMapping("/explotacion")
    public ResponseEntity<Explotacion> crearExplotacion(@RequestBody Explotacion explotacion) {
        Explotacion nuevaExplotacion = explotacionService.saveAndFlush(explotacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaExplotacion);
    }

    // Otros métodos para crear, actualizar, y eliminar usuarios
}