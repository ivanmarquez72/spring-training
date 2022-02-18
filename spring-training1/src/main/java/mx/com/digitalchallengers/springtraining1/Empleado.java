package mx.com.digitalchallengers.springtraining1;

import org.springframework.stereotype.Service;

@Service
//Tambien hace un bean
public class Empleado {
    private Escuela escuela;

    public void historia(){
        System.out.println("Estudie en la UNAM y trabajo en DigitalChallengers");
    }
}
