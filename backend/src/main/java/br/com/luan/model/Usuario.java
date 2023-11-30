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
class Usuario {

    @Id
    private Long id;
    private String nome;
    private String sobreNome;
    private String email;
    private String cpf;
    private String senha;
    @OneToOne(mappedBy = "usuario")
    private FotoRostoUsuario fotoRostoUsuario;
    @OneToMany(mappedBy = "usuario")
    private List<Dispositivo> dispositivos;
    private boolean cadastroCompleto;
}