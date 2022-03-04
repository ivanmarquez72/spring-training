package mx.com.digitalchallengers.springtraining2.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    //Unidireccionalidad desde Cliente
    //@OneToMany(mappedBy = "cliente")// cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id_cliente")
    private List<Factura> facturas = new ArrayList<>();


}
