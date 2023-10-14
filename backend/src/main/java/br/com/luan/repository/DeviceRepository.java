package br.com.luan.repository;

import br.com.luan.model.Device;
import br.com.luan.model.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class DeviceRepository extends BaseRepository<Device, Long> {

    public Device findByBluetoothIdentifier(UUID bluetoothIdentifier) {
        //language=JPAQL
        String query = "FROM Device WHERE bluetoothIdentifier = ?1";
        return find(query, bluetoothIdentifier).firstResult();
    }

    public List<Device> findAllByUser(User user) {
        //language=JPAQL
        String query = "FROM Device WHERE user = ?1";
        return find(query, user).list();
    }
}

