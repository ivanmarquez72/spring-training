package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int idFactura;
    @Column(name = "fechaFactura")
    private String fecha;
    @Column(name = "referenciaFactura")
    private String referenciaFactura;

    @ManyToOne
//    @JoinColumn(
//            name = "idCliente",                 //nombre de la columna en la DB
//            referencedColumnName = "idCliente"  //referencia al atributo del objeto
//    )
    private Cliente cliente;

}
