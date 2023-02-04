package org.rmc.coches.controller;

import java.util.Optional;
import org.rmc.coches.model.entity.Extra;
import org.rmc.coches.service.ExtraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class ExtraController extends CommonController<Extra, ExtraService> {

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody Extra extra, @PathVariable Long id) {
        Optional<Extra> o = this.service.findById(id);
        if (o.isEmpty())
            return ResponseEntity.notFound().build();
        Extra extraDB = o.get();
        extraDB.update(extra);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(extraDB));
    }

}
