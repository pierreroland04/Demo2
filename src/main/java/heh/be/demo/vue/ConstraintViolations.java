package heh.be.demo.vue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConstraintViolations {
    private String fieldName;
    private String message;
    private String rejectedValue;
}


