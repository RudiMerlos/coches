package org.rmc.coches.service;

import org.rmc.coches.model.entity.Marca;
import org.rmc.coches.model.repository.MarcaRepository;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl extends CommonServiceImpl<Marca, MarcaRepository> implements MarcaService {
}
