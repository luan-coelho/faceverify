package br.com.luan.service;

import br.com.luan.dto.CreatePointRegistrationDTO;
import br.com.luan.model.PointRegistration;
import br.com.luan.repository.PointRegistrationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;

@ApplicationScoped
public class PointRegistrationService extends BaseService<PointRegistration, Long, PointRegistrationRepository> {

    @Inject
    EventService eventService;

    @Transactional
    public PointRegistration create(CreatePointRegistrationDTO dto) {
        eventService
                .findByIdOptional(dto.event().getId())
                .orElseThrow(() -> new BadRequestException("Event not found by id"));

        PointRegistration pointRegistration = CreatePointRegistrationDTO.dataTransferObjectToEntity(dto);
        for (int i = 0; i < pointRegistration.getPoints().size(); i++) {
            pointRegistration.getPoints().get(i).setPointRegistration(pointRegistration);
        }
        this.repository.persist(pointRegistration);
        return pointRegistration;
    }
}
