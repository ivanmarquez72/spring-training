package mx.com.digitalchallengers.springtraining2.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int idFactura;

    @Column(name = "fechaFactura")
    private String fecha;

    @Column(name = "referenciaFactura")
    private String referenciaFactura;

    //Unidireccionalidad desde Facturas
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id_cliente")
    //JoinColumn se le pone el nombre de la clave foranea que esta en esta clase
    @JsonBackReference
    private Cliente cliente;

    //JoinColumn y Column no pueden ir juntas
    //Unidecchionalidad solo una puede tener la notacion de la relacion

    @ManyToMany
    @JoinTable(
            name = "factura_producto",
            joinColumns = @JoinColumn(
                    name = "factura_id",
                    referencedColumnName = "idFactura"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id_producto",
                    referencedColumnName = "idProducto"
            )
    )
    private List<Producto> productos = new ArrayList<>();

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", fecha='" + fecha + '\'' +
                ", referenciaFactura='" + referenciaFactura + '\'' +
                '}';
    }
}
