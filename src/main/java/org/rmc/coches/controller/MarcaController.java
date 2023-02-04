package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Marca;
import org.rmc.coches.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class MarcaController extends CommonController<Marca, MarcaService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Marca marca, @PathVariable Long id) {
        Optional<Marca> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Marca marcaDB = o.get();
        marcaDB.update(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(marcaDB));
    }

}
