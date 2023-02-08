package org.rmc.coches.model.repository;

import java.util.List;
import org.rmc.coches.model.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CocheRepository extends JpaRepository<Coche, Long> {
    
    @Query("select c from Coche c join fetch c.marca m join fetch c.precios p")
    List<Coche> findAllCoches();
    
}
