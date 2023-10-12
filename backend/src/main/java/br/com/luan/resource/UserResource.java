package br.com.luan.resource;

import br.com.luan.model.User;
import br.com.luan.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

@Path("/user")
public class UserResource {

    @Inject
    UserService service;

    @Path("/{id}")
    @GET
    public Response getById(@RestPath("id") Long id) {
        User user = service.findById(id);
        return Response.ok(user).build();
    }
}
