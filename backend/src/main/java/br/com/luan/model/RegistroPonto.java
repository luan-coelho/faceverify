package br.com.luan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class RegistroPonto {

    @Id
    private Long id;
    private LocalDate data;
    @ManyToOne
    private Evento evento;
    @OneToMany(mappedBy = "registroPonto")
    private List<Ponto> pontos;
    @OneToMany(mappedBy = "registroPonto")
    private List<Fator> fatores;
    private boolean emAndamento;
}