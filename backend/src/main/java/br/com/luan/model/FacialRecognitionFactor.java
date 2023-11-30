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
class FacialRecognitionFactor extends Factor {

    @Id
    private Long id;

    @Override
    public void validate() {
        // Implementation
    }
}