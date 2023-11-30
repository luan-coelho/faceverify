package br.com.luan.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}