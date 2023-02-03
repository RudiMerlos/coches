package org.rmc.coches.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonServiceImpl<E, R extends JpaRepository<E, Long>> implements CommonService<E> {

    @Autowired
    protected R repository;

    @Override
    @Transactional(readOnly = true)
    public List<E> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entity) {
        return this.repository.save(entity);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

}
