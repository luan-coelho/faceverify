package br.com.luan.service;

import br.com.luan.commons.pagination.Paginacao;
import br.com.luan.commons.pagination.PaginacaoDados;
import br.com.luan.commons.pagination.Paginavel;
import br.com.luan.repository.BaseRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

public abstract class BaseService<T, R extends BaseRepository<T>> {

    @Inject
    public R repository;

    public PaginacaoDados<T> buscarTodosPaginados(Paginavel paginavel) {
        List<T> lista = repository.listAll();
        return construirPaginacaoDeDados(lista, paginavel);
    }

    public T buscarPeloId(Long id) {
        return repository
                .findByIdOptional(id)
                .orElseThrow(() -> new NotFoundException("Recurso não encontrado por id"));
    }

    @Transactional
    public T criar(T entity) {
        repository.persist(entity);
        return entity;
    }

    @Transactional
    public T atualizar(T entity) {
        return repository.getEntityManager().merge(entity);
    }

    @Transactional
    public void deletarPeloId(Long id) {
        buscarPeloId(id);
        repository.deleteById(id);
    }

    protected PaginacaoDados<T> construirPaginacaoDeDados(List<T> dados, Paginavel paginavel) {
        Paginacao paginacao = repository.construirPaginacao(paginavel);
        return new PaginacaoDados(dados, paginacao);
    }
}