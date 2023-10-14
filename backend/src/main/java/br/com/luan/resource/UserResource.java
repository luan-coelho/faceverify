package br.com.luan.resource;

import br.com.luan.model.User;
import br.com.luan.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

@Path("/user")
public class UserResource {

    @Inject
    UserService service;

    @GET
    public Response getAll() {
        List<User> users = service.findAll();
        return Response.ok(users).build();
    }

    @Path("/{id}")
    @GET
    public Response getById(@RestPath("id") Long id) {
        User user = service.findById(id);
        return Response.ok(user).build();
    }
}
