package br.com.luan.service;

import br.com.luan.repository.BaseRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.UUID;

public abstract class BaseService<T, R extends BaseRepository<T>> {

    @Inject
    R repository;

    public List<T> findAll() {
        return repository.listAll();
    }

    public T findById(UUID id) {
        return repository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Resource not found by id"));
    }

    @Transactional
    public T create(T entity) {
        repository.persist(entity);
        return entity;
    }

    @Transactional
    public T update(T entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deleteById(UUID id) {
        findById(id);
        repository.deleteById(id);
    }
}

