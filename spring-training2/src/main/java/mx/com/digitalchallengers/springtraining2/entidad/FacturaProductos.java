package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "factura_producto")
public class FacturaProductos {
    @Column
    private int idFactura;
    @Column
    private int idProducto;
}
