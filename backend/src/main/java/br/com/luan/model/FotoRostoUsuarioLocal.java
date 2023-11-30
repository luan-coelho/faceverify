package br.com.luan.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class FotoRostoUsuarioLocal extends FotoRostoUsuario {

    private String caminhoArquivo;
}