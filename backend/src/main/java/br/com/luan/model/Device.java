package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Device {

    @Id
    private UUID identifier;
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
