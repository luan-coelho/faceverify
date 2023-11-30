package br.com.luan.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Ponto {

    @Id
    private Long id;
    private LocalTime horaInicio;
    private int minutosParaValidar;
    private boolean validado;
    @ManyToOne
    private RegistroPonto registroPonto;
}