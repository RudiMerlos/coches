package org.rmc.coches.service;

import org.rmc.coches.model.entity.Coche;
import org.rmc.coches.model.repository.CocheRepository;
import org.springframework.stereotype.Service;

@Service
public class CocheServiceImpl extends CommonServiceImpl<Coche, CocheRepository> implements CocheService {
}
