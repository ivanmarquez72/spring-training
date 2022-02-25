package mx.com.digitalchallengers.springtraining1;

import org.springframework.stereotype.Service;

@Service
//Tambien hace un bean
public class Empleado {
    private Escuela escuela;
    private String nombre;

    public void historia(){
        System.out.println("Estudie en la UNAM y trabajo en DigitalChallengers");
    }

    public String historiaReturn(){
        return "Estudie en la UNAM y trabajo en DigitalChallengers";
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
