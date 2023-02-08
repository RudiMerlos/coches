package org.rmc.coches.service;

import java.util.List;
import org.rmc.coches.model.entity.Coche;

public interface CocheService extends CommonService<Coche> {
    
    List<Coche> findAllCoches();
    
}
