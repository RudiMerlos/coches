package org.rmc.coches.service;

import org.rmc.coches.model.entity.Precio;
import org.rmc.coches.model.repository.PrecioRepository;
import org.springframework.stereotype.Service;

@Service
public class PrecioServiceImpl extends CommonServiceImpl<Precio, PrecioRepository> implements PrecioService {
}
