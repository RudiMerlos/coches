package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Precio;
import org.rmc.coches.service.PrecioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/precios")
public class PrecioController extends CommonController<Precio, PrecioService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> editCoche(@RequestBody Precio precio, @PathVariable Long id) {
        Optional<Precio> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Precio precioDB = o.get();
        precioDB.update(precio);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(precioDB));
    }

}
