package br.com.luan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
class Event {

    @Id
    private Long id;
    private String description;
    @OneToMany(mappedBy = "event")
    private List<PointRecord> pointRecords;
    @OneToOne
    private Location location;
}