package br.com.luan.resource;

import br.com.luan.dto.CreatePointRegistrationDTO;
import br.com.luan.dto.RegisterPointDTO;
import br.com.luan.model.PointRegistration;
import br.com.luan.service.PointRegistrationService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

@Path("/point-registration")
public class PointRegistrationResource {

    @Inject
    PointRegistrationService service;

    @Path("/{id}")
    @GET
    public Response getById(@RestPath("id") Long id) {
        PointRegistration pointRegistration = service.findById(id);
        return Response.ok(pointRegistration).build();
    }

    @POST
    public Response create(CreatePointRegistrationDTO createPointRegistrationDTO) {
        PointRegistration pointRegistration = service.create(createPointRegistrationDTO);
        return Response.ok(pointRegistration).status(Response.Status.CREATED).build();
    }

    @Path("/register-point")
    @POST
    public Response registerPoint(RegisterPointDTO registerPointDTO) {
        return Response.ok().build();
    }
}
