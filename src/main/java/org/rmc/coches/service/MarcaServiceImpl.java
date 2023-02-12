package org.rmc.coches.service;

import java.util.List;
import java.util.Optional;
import org.rmc.coches.model.entity.Marca;
import org.rmc.coches.model.repository.MarcaRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl extends CommonServiceImpl<Marca, MarcaRepository> implements MarcaService {

    @Override
    public List<Marca> findAllMarcas() {
        return this.repository.findAllMarcas();
    }

    @Override
    public Optional<Marca> findMarcaById(Long id) {
        return this.repository.findMarcaById(id);
    }
}
