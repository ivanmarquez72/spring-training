package mx.com.digitalchallengers.nativeSQL;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Entity(name="producto")
@Table(name = "producto")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @Column(name="idProducto")
    @GeneratedValue
    private int idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private int precio;

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
