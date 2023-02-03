package org.rmc.coches.model.repository;

import org.rmc.coches.model.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche, Long> {
}
