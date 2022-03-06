package mx.com.digitalchallengers.springtraining2.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    // una forma, sin las notaciones
    @OneToMany(cascade = CascadeType.ALL)
    //En JoinColumn debe de ir el nombre de la columna en la base de datos no de la variable
    @JoinColumn(name = "cliente_id_cliente")
    //@JsonManagedReference
    private List<Factura> facturas = new ArrayList<>();


}
