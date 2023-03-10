package org.rmc.coches.service;

import java.util.List;
import java.util.Optional;

public interface CommonService<E> {

    List<E> findAll();

    Optional<E> findById(Long id);

    E save(E entity);

    void deleteById(Long id);

}
