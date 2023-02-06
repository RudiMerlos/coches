package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Coche;
import org.rmc.coches.service.CocheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coches")
public class CocheController extends CommonController<Coche, CocheService> {
    
    public ResponseEntity<?> editCoche(@RequestBody Coche coche, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        cocheDB.update(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }

}
