package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "point_registration")
@Entity
public class PointRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_registration_seq")
    @SequenceGenerator(name = "point_registration_seq", sequenceName = "point_registration_seq", allocationSize = 1)
    @Column(name = "point_registration_id")
    private Long id;
    private LocalDate date;
    @OneToMany
    @JoinTable(
            name = "point_registration_users",
            joinColumns = @JoinColumn(name = "point_registration_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
    @OneToMany
    @JoinTable(
            name = "point_registration_points",
            joinColumns = @JoinColumn(name = "point_registration_id"),
            inverseJoinColumns = @JoinColumn(name = "point_id")
    )
    private List<Point> points;
}
