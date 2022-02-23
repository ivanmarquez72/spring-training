package mx.com.digitalchallengers.interfaz;

import org.springframework.stereotype.Service;

@Service
public class InterfazEjercicio {
    private int a = 10, b = 9;

    //Interfaz e implemantacion
    public void ejemplo() {
        OperacionImpl operacion = new OperacionImpl();

        int suma = operacion.suma(a, b);
        int resta = operacion.resta(a, b);

        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
    }
}
