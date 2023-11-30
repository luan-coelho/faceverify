package br.com.luan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Device> devices;
    private boolean completeRegistration;
}