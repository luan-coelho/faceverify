package br.com.luan.repository;

import br.com.luan.commons.pagination.Paginavel;
import br.com.luan.commons.pagination.Paginacao;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public abstract class BaseRepository<T> implements PanacheRepositoryBase<T, Long> {

    public Paginacao construirPaginacao(Paginavel paginavel) {
        long numeroRegistros = count();
        long totalPaginas = numeroRegistros / paginavel.getTamanho();
        return new Paginacao(paginavel.getPagina(), totalPaginas, numeroRegistros);
    }
}
