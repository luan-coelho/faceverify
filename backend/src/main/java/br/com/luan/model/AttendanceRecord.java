package br.com.luan.model;

import java.time.LocalDateTime;

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
class AttendanceRecord {

    @Id
    private Long id;
    private LocalDateTime dateTime;
    @ManyToOne
    private Participant participant;
    @ManyToOne
    private Point point;
}