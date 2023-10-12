package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "face_photo")
@Entity
public class FacePhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "facephoto_seq")
    @SequenceGenerator(name = "facephoto_seq", sequenceName = "facephoto_seq", allocationSize = 1)
    @Column(name = "face_photo_id")
    private Long id;
}
