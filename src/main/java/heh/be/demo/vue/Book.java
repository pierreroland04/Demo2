package heh.be.demo.vue;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @NotNull
    private String title;
    @NotNull
    private Integer id;
}
