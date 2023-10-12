package br.com.luan.service;

import br.com.luan.model.Device;
import br.com.luan.repository.DeviceRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class DeviceService extends BaseService<Device, Long, DeviceRepository> {

    public Device findByBluetoothIdentifier(UUID bluetoothIdentifier) {
        return this.repository.findByBluetoothIdentifier(bluetoothIdentifier);
    }
}
