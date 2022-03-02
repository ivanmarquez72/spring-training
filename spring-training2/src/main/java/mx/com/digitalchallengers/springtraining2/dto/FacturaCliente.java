package mx.com.digitalchallengers.springtraining2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FacturaCliente {

    private String nombre;
    private String apellido;
    private String fecha;
    private String referencia;
}
