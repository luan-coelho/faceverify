package br.com.luan.dto;

import br.com.luan.model.Event;
import br.com.luan.model.Point;
import br.com.luan.model.PointRegistration;
import br.com.luan.model.User;

import java.time.LocalDate;
import java.util.List;

public record CreatePointRegistrationDTO(Long id,
                                         LocalDate date,
                                         List<User> users,
                                         List<Point> points,
                                         Event event) {

    public static PointRegistration dataTransferObjectToEntity(CreatePointRegistrationDTO dto) {
        PointRegistration pointRegistrationEntity = new PointRegistration();

        pointRegistrationEntity.setId(dto.id);
        pointRegistrationEntity.setDate(dto.date());
        pointRegistrationEntity.setUsers(dto.users());
        pointRegistrationEntity.setPoints(dto.points());
        pointRegistrationEntity.setEvent(dto.event());

        return pointRegistrationEntity;
    }
}
