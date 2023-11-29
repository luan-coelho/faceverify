package br.com.luan.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class PointRecord {

    @Id
    private Long id;
    private LocalDate date;
    @ManyToOne
    private Event event;
    @OneToMany(mappedBy = "pointRecord")
    private List<Point> points;
}