package br.com.luan.model;

import java.io.File;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
abstract class FotoRostoUsuario {

    @Id
    private Long id;
    private File arquivo;
    private String tipoMime;
    private long tamanhoArquivo;
    private String nomeArquivo;
    private LocalDate dataUpload;
    @OneToOne
    private Usuario usuario;
}