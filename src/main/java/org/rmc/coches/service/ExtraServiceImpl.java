package org.rmc.coches.service;

import org.rmc.coches.model.entity.Extra;
import org.rmc.coches.model.repository.ExtraRepository;
import org.springframework.stereotype.Service;

@Service
public class ExtraServiceImpl extends CommonServiceImpl<Extra, ExtraRepository> implements ExtraService {
}
