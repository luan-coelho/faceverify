package br.com.luan.model;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Point {

    @Id
    private Long id;
    private LocalTime startTime;
    private int minutesToValidate;
    private boolean validated;
    @ManyToOne
    private PointRecord pointRecord;
}