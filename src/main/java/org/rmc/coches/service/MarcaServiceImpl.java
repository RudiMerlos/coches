package org.rmc.coches.service;

import java.util.List;
import java.util.Optional;
import org.rmc.coches.model.entity.Marca;
import org.rmc.coches.model.repository.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MarcaServiceImpl extends CommonServiceImpl<Marca, MarcaRepository> implements MarcaService {

    @Override
    @Transactional(readOnly = true)
    public List<Marca> findAllMarcas() {
        return this.repository.findAllMarcas();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Marca> findMarcaById(Long id) {
        return this.repository.findMarcaById(id);
    }
}
