package br.com.luan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class IndoorLocationFactor implements Factor {

    @Id
    private Long id;
    private Float permittedRadiusInMeters;

    @Override
    public void validate() {
        // Implementation
    }
}