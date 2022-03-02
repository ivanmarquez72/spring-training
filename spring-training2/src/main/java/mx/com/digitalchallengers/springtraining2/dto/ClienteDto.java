package mx.com.digitalchallengers.springtraining2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDto {
    private int idCliente;
    private String nombre;
    private String apellido;

}
