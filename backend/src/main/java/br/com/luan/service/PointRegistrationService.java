package br.com.luan.service;

import br.com.luan.dto.CreatePointRegistrationDTO;
import br.com.luan.model.PointRegistration;
import br.com.luan.repository.PointRegistrationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PointRegistrationService extends BaseService<PointRegistration, Long, PointRegistrationRepository> {

    @Override
    public PointRegistration findById(Long id) {
        return this.repository.findById(id);
    }

    @Transactional
    public PointRegistration create(CreatePointRegistrationDTO dto) {
        PointRegistration pointRegistration = CreatePointRegistrationDTO.dataTransferObjectToEntity(dto);
        for (int i = 0; i < pointRegistration.getPoints().size(); i++) {
            pointRegistration.getPoints().get(i).setPointRegistration(pointRegistration);
        }
        this.repository.persist(pointRegistration);
        return pointRegistration;
    }
}
