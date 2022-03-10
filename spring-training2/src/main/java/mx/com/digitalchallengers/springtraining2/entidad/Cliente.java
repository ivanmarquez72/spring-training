package mx.com.digitalchallengers.springtraining2.entidad;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "cliente"
        //,UniqueConstraints = @UniqueConstraint(
        //        name = "nombreid_s",
        //        columnNames = "nombre"
        //)
)
public class Cliente implements Serializable {
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
            fetch = FetchType.EAGER
            //mappedBy = "cliente"
            //,orphanRemoval = true
    )
    //En JoinColumn debe de ir el nombre de la columna en la base de datos no de la variable
    //la columna que es llave foranea de esta clase o tabla
    //@JoinColumn(name = "cliente_id_cliente")
    @JsonManagedReference
    private List<Factura> facturas = new ArrayList<>();

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", facturas=" + facturas +
                '}';
    }
}