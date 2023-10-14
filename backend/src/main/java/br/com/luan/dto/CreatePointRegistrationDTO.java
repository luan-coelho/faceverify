package br.com.luan.dto;

import br.com.luan.model.Event;
import br.com.luan.model.Point;
import br.com.luan.model.PointRegistration;
import br.com.luan.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CreatePointRegistrationDTO(Long id,
                                         Event event,
                                         LocalDate date,
                                         User manager,
                                         UUID bluetoothIdentifier,
                                         List<User> users,
                                         List<Point> points) {

    public static PointRegistration dataTransferObjectToEntity(CreatePointRegistrationDTO dto) {
        PointRegistration pointRegistrationEntity = new PointRegistration();

        pointRegistrationEntity.setId(dto.id);
        pointRegistrationEntity.setEvent(dto.event);
        pointRegistrationEntity.setDate(dto.date);
        pointRegistrationEntity.setManager(dto.manager);
        pointRegistrationEntity.setBluetoothIdentifier(dto.bluetoothIdentifier);
        pointRegistrationEntity.setUsers(dto.users);
        pointRegistrationEntity.setPoints(dto.points);

        return pointRegistrationEntity;
    }
}
