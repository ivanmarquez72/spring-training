package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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

    @ManyToOne(
            fetch = FetchType.LAZY
    )
//    @JoinColumn(
//            name = "cliente_id_cliente",      //nombre de la columna en la DB
//            referencedColumnName = "cliente"  //referencia al atributo del objeto
//    )
    private Cliente cliente;

}
