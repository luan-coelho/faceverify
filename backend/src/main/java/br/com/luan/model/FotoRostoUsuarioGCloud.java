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
class FotoRostoUsuarioGCloud extends FotoRostoUsuario {

    private String nomeBucket;
    private String chaveObjeto;
}