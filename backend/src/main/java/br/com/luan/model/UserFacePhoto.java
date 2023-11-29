package br.com.luan.model;

import java.io.File;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
abstract class UserFacePhoto {

    @Id
    private Long id;
    private File file;
    private String mimeType;
    private long fileSize;
    private String fileName;
    private LocalDate uploadDate;
}