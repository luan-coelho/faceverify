package br.com.luan.resource;

import br.com.luan.model.Device;
import br.com.luan.service.DeviceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;

import java.util.UUID;

@Path("/device")
public class DeviceResource {

    @Inject
    DeviceService service;

    @Path("/{identifier}")
    @GET
    public Response getById(@RestPath("identifier") UUID identifier) {
        Device device = service.findById(identifier);
        return Response.ok(device).build();
    }
}
