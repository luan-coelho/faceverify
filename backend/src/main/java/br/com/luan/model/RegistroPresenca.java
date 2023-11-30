package br.com.luan.model;

import java.time.LocalDateTime;

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
class RegistroPresenca {

    @Id
    private Long id;
    private LocalDateTime dataHora;
    @ManyToOne
    private Participante participante;
    @ManyToOne
    private Ponto ponto;
}