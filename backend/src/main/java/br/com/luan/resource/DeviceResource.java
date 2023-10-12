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

    @Path("/{id}")
    @GET
    public Response getById(@RestPath("id") Long id) {
        Device device = service.findById(id);
        return Response.ok(device).build();
    }

    @Path("/bluetooth-identifier/{uuid}")
    @GET
    public Response getByBluetoothIdentifier(@RestPath("uuid") UUID uuid) {
        Device device = service.findByBluetoothIdentifier(uuid);
        return Response.ok(device).build();
    }
}
