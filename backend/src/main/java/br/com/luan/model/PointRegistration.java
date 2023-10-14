package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

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

    @ManyToMany
    @JoinTable(
            name = "point_registration_user",
            joinColumns = @JoinColumn(name = "point_registration_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @JoinColumn(name = "manager_id")
    @ManyToOne
    private User manager;

    @Column(name = "bluetooth_identifier")
    private UUID bluetoothIdentifier;

    @OneToMany(mappedBy = "pointRegistration", cascade = CascadeType.ALL)
    private List<Point> points;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
