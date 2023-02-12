package org.rmc.coches.model.repository;

import java.util.List;
import java.util.Optional;
import org.rmc.coches.model.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
    @Query("select m from Marca m left join fetch m.coches c")
    List<Marca> findAllMarcas();
    
    @Query("select m from Marca m left join fetch m.coches c where m.id = ?1")
    Optional<Marca> findMarcaById(Long id);
    
}
