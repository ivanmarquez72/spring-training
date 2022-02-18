package mx.com.digitalchallengers.springtraining1;

import org.springframework.stereotype.Service;

@Service
public class Escuela {
    Alumno alumno = new Alumno();
    String nombre = "UNAM";

    public Escuela(Alumno alumno) {
        this.alumno = alumno;
    }

    public Escuela() {
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Escuela{" +
                "alumno=" + alumno +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
