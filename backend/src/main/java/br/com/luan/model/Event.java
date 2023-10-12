package br.com.luan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize = 1)
    @Column(name = "event_id")
    private Long id;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "event")
    private List<PointRegistration> pointRegistrations;
}
