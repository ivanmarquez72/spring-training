package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(
        name = "cliente"
        //,UniqueConstraints = @UniqueConstraint(
        //        name = "nombreid_s",
        //        columnNames = "nombre"
        //)
)
public class Cliente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int idCliente;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;

   @OneToMany(
           mappedBy = "cliente",
           cascade = CascadeType.ALL,
           fetch = FetchType.LAZY
   )
//   @JoinColumn(
//           name = "id_cliente",
//           referencedColumnName = "idCliente"
//   )
    private List<Factura> facturas = new ArrayList<>();
}
