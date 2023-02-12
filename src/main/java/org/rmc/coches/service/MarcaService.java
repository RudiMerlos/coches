package org.rmc.coches.service;

import java.util.List;
import java.util.Optional;
import org.rmc.coches.model.entity.Marca;

public interface MarcaService extends CommonService<Marca> {
    
    List<Marca> findAllMarcas();
    
    Optional<Marca> findMarcaById(Long id);
    
}
