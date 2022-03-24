package mx.com.digitalchallengers.springtraining2.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "producto"
)
public class Producto implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private float precio;


}
