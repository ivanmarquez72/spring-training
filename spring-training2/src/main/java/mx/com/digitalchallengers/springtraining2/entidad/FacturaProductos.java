package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacturaProductos {
    private int idFactura;
    private int idProducto;
}
