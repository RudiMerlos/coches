package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Marca;
import org.rmc.coches.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcaController {

    @Autowired
    private MarcaService service;
    
    @GetMapping("/marcas")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/marca/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Marca> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o.get());
    }
    
    @PostMapping("/marca")
    public ResponseEntity<?> create(@RequestBody Marca marca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(marca));
    }

    @PutMapping("/marca/{id}")
    public ResponseEntity<?> editCoche(@RequestBody Marca marca, @PathVariable Long id) {
        Optional<Marca> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Marca marcaDB = o.get();
        marcaDB.update(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(marcaDB));
    }
    
    @DeleteMapping("/marca/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
