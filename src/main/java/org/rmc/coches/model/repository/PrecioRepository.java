package org.rmc.coches.model.repository;

import org.rmc.coches.model.entity.Precio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecioRepository extends JpaRepository<Precio, Long> {
}
