package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}
