package br.com.luan.model;

import jakarta.persistence.*;
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
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate data;
    @ManyToOne
    private Evento evento;
    @OneToMany(mappedBy = "registroPonto")
    private List<Ponto> pontos;
    private List<Fator> fatores;
    private boolean emAndamento;
}