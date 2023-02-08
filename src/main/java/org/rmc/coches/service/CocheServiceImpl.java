package org.rmc.coches.service;

import java.util.List;
import org.rmc.coches.model.entity.Coche;
import org.rmc.coches.model.repository.CocheRepository;
import org.springframework.stereotype.Service;

@Service
public class CocheServiceImpl extends CommonServiceImpl<Coche, CocheRepository> implements CocheService {

    @Override
    public List<Coche> findAllCoches() {
        return this.repository.findAllCoches();
    }
}
