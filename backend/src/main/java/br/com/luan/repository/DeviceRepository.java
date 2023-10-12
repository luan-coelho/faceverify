package br.com.luan.repository;

import br.com.luan.model.Device;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class DeviceRepository extends BaseRepository<Device, Long> {

    public Device findByBluetoothIdentifier(UUID bluetoothIdentifier) {
        String query = "FROM Device WHERE bluetoothIdentifier = ?1";
        return find(query, bluetoothIdentifier).firstResult();
    }
}

