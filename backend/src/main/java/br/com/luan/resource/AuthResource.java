package br.com.luan.resource;

import br.com.luan.CriarParticipanteDTO;
import br.com.luan.service.ParticipanteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {

    @Inject
    ParticipanteService participanteService;

    @GET
    public Response cadastrar(CriarParticipanteDTO participanteDTO) {
        return Response.ok(participanteService.criar(participanteDTO)).build();
    }
}
