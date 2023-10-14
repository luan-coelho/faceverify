package br.com.luan.dto;

import java.util.UUID;

public record RegisterPointDTO(UUID bluetoothIdentifier, String wifiNetworkIp) {
}
