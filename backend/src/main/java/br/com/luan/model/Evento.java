package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Evento {

    @Id
    private Long id;
    private String descricao;
    @OneToMany(mappedBy = "evento")
    private List<RegistroPonto> registrosPonto;
    @OneToOne
    private Localizacao localizacao;
    @ManyToMany
    private List<Participante> participantes;
    private boolean permitirSolicitacoes;
}