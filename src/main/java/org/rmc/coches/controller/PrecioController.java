package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Precio;
import org.rmc.coches.service.PrecioService;
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
public class PrecioController {

    @Autowired
    private PrecioService service;
    
    @GetMapping("/precios")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/precio/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Precio> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o.get());
    }
    
    @PostMapping("/precio")
    public ResponseEntity<?> create(@RequestBody Precio precio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(precio));
    }

    @PutMapping("/precio/{id}")
    public ResponseEntity<?> editCoche(@RequestBody Precio precio, @PathVariable Long id) {
        Optional<Precio> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Precio precioDB = o.get();
        precioDB.update(precio);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(precioDB));
    }
    
    @DeleteMapping("/precio/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
