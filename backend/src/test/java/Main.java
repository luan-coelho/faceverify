
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Environment {
    @Id
    private Long id;
    private String title;
    private String description;
}
