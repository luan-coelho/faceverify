package br.com.luan.service;

import br.com.luan.model.Device;
import br.com.luan.repository.DeviceRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeviceService extends BaseService<Device, DeviceRepository> {

}
