package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Coche;
import org.rmc.coches.service.CocheService;
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
public class CocheController {
    
    @Autowired
    private CocheService service;
    
    @GetMapping("/coches")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/coche/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o.get());
    }
    
    @PostMapping("/coche")
    public ResponseEntity<?> create(@RequestBody Coche coche) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(coche));
    }

    @PutMapping("/coche/{id}")
    public ResponseEntity<?> editCoche(@RequestBody Coche coche, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        cocheDB.update(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }
    
    @DeleteMapping("/coche/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
