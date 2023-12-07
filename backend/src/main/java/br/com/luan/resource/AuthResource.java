package br.com.luan.resource;

import br.com.luan.CriarUsuarioDTO;
import br.com.luan.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {

    @Inject
    UsuarioService usuarioService;

    @GET
    public Response cadastrar(CriarUsuarioDTO usuarioDTO) {
        return Response.ok(usuarioService.criar(usuarioDTO)).build();
    }
}
