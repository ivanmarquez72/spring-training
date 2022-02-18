package mx.com.digitalchallengers.springtraining1;

import org.springframework.stereotype.Service;

@Service
public class Alumno {
    private String nombre;

    public Alumno() {
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
