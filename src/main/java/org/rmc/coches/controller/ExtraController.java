package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Extra;
import org.rmc.coches.service.ExtraService;
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
public class ExtraController {

    @Autowired
    private ExtraService service;
    
    @GetMapping("/extras")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(this.service.findAll());
    }
    
    @GetMapping("/extra/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Extra> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(o.get());
    }
    
    @PostMapping("/extra")
    public ResponseEntity<?> create(@RequestBody Extra extra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(extra));
    }

    @PutMapping("/extra/{id}")
    public ResponseEntity<?> editCoche(@RequestBody Extra extra, @PathVariable Long id) {
        Optional<Extra> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Extra extraDB = o.get();
        extraDB.update(extra);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(extraDB));
    }
    
    @DeleteMapping("/extra/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
