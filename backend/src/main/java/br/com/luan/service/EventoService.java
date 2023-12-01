package br.com.luan.service;

import br.com.luan.commons.pagination.PaginacaoDados;
import br.com.luan.commons.pagination.Paginavel;
import br.com.luan.model.Evento;
import br.com.luan.repository.EventoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EventoService extends BaseService<Evento, EventoRepository>{

    public PaginacaoDados<Evento> buscarTodos(Paginavel paginavel) {
        return this.buscarTodosPaginados(paginavel);
    }
}
