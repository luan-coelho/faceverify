package br.com.luan.resource;

import br.com.luan.commons.pagination.Paginavel;
import br.com.luan.model.Evento;
import br.com.luan.service.EventoService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/evento")
public class EventoResource {

    @Inject
    EventoService eventoService;

    @GET
    public Response buscarTodos(Paginavel paginavel) {
        return Response.ok(eventoService.buscarTodos(paginavel)).build();
    }

    @POST
    public Response criar(Evento evento) {
        eventoService.criar(evento);
        return Response.status(Response.Status.CREATED).build();
    }
}
