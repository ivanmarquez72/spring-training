package mx.com.digitalchallengers.cola;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class ColaEjercicio {
    private Queue<String> cola = new LinkedList<>();

    public Queue colaFuncionamiento(){
        //Queue
        Queue<String> cola = new LinkedList<>();
        cola.add("Ivan");
        cola.add("Alexis");
        cola.add("Liz");
        System.out.println("El numero de elementos es: " + cola.size());
        System.out.println("Extraer el elemento (" +cola.poll() + ")");
        System.out.println("El numero de elementos es: " + cola.size());
        System.out.println("Consultamos el primer elemento sin extraer " + cola.peek());
        System.out.println();
        while(!cola.isEmpty()){
            System.out.print(cola.poll() + " - ");
        }
        System.out.println();

        return cola;
    }
}
