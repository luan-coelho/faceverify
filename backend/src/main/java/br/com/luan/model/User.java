package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "user_id")
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Device> devices;
    @OneToOne
    @JoinColumn(name = "face_photo")
    private FacePhoto facePhoto;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
