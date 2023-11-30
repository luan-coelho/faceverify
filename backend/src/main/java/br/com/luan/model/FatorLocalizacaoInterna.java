package br.com.luan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class FatorLocalizacaoInterna extends Fator {

    @Id
    private Long id;
    private Float raioPermitidoEmMetros;

}