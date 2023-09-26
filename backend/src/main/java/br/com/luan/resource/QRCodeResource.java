package br.com.luan.resource;

import br.com.luan.dto.GenerateQRCodeDTO;
import br.com.luan.service.QRCodeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/api/qrcode")
public class QRCodeResource {

    @Inject
    QRCodeService service;

    @POST
    @Produces("image/png")
    public Response generateQRCode(GenerateQRCodeDTO requestDTO) {
        byte[] qrCode = service.generateQRCode(requestDTO.value());
        return Response.ok(qrCode).build();
    }
}
