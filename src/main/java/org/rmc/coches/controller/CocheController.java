package org.rmc.coches.controller;

import java.util.List;
import java.util.Optional;
import org.rmc.coches.model.entity.Coche;
import org.rmc.coches.model.entity.Extra;
import org.rmc.coches.model.entity.Precio;
import org.rmc.coches.service.CocheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coches")
public class CocheController extends CommonController<Coche, CocheService> {
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editCoche(@RequestBody Coche coche, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        cocheDB.update(coche);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }
    
    @PutMapping("/{id}/add-precios")
    public ResponseEntity<?> addPrecios(@RequestBody List<Precio> precios, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        precios.forEach(cocheDB::addPrecio);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }
    
    @PutMapping("/{id}/delete-precio")
    public ResponseEntity<?> removePrecio(@RequestBody Precio precio, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        cocheDB.removePrecio(precio);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }

    @PutMapping("/{id}/add-extras")
    public ResponseEntity<?> addExtras(@RequestBody List<Extra> extras, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        extras.forEach(cocheDB::addExtra);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }

    @PutMapping("/{id}/delete-extra")
    public ResponseEntity<?> removeExtra(@RequestBody Extra extra, @PathVariable Long id) {
        Optional<Coche> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Coche cocheDB = o.get();
        cocheDB.removeExtra(extra);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(cocheDB));
    }

}
