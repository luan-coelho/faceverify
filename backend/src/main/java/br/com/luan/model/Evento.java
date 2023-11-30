package br.com.luan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
}