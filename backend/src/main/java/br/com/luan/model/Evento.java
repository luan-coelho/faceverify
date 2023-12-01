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
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descricao;
    @OneToMany(mappedBy = "evento")
    private List<RegistroPonto> registrosPonto;
    @OneToOne(mappedBy = "evento")
    private Localizacao localizacao;
    @ManyToMany
    private List<Participante> participantes;
    private String codigo;
    private boolean permitirSolicitacoesIngresso;
}