package mx.com.digitalchallengers.springtraining1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;

@RestController
public class HelloController {
    @Autowired
    private Empleado empleado;

    @Autowired
    private Alumno alumno;

    @Autowired
    private Escuela escuela;

    @Autowired
    private Empleado emp;

    @GetMapping("/")
    public String index(){
        System.out.println("Greetings form Spring Boot!");
        return "Greetings form Spring Boot!";
    }

    @GetMapping("/ejemplo")
    public String ejemplo(){
        System.out.println("Este sera el ejemplo");
        return "Este es el primer ejemplo";
    }

    @GetMapping("/empleado")
    public String empleado(){
        System.out.println("Ejemplo de empleado");
        return empleado.historiaReturn();
    }

    @GetMapping("/alumno")
    public String alumno(){
        alumno.setNombre("Ivan");
        return alumno.toString();
    }

    @GetMapping("/empleadoEscuela")
    public String empleadoEscuela(){
        alumno.setNombre("Ivan");
        escuela.setNombre("FES Aragon!");
        escuela.setAlumno(alumno);
        empleado.setNombre("Ricardo");
        empleado.setEscuela(escuela);
        String frase;
        frase = empleado.getNombre() + " " + alumno.getNombre() + " " + escuela.getNombre();
        return frase;
    }



}
