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

    //Unidireccionalidad desde cliente
//    @Column(name = "cliente_id_cliente" )
//    private int cliente;

    //JoinColumn y Column no pueden ir juntas
    //Unidecchionalidad solo una puede tener la notacion de la relacion

    //Unidireccionalidad desde Facturas
    @ManyToOne //(fetch = FetchType.LAZY)
    private Cliente cliente;

}
