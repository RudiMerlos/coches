package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Coche;
import org.rmc.coches.service.CocheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CocheController extends CommonController<Coche, CocheService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Coche coche, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        cocheDB.update(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }

}
