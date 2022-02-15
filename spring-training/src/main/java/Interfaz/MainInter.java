package Interfaz;

public class MainInter {
    //Interfaz e implemantacion
    public void ejemplo() {
        Interfaz.OperacionImpl operacion = new Interfaz.OperacionImpl();
        int a = 10;
        int b = 9;

        int suma = operacion.suma(a, b);
        int resta = operacion.resta(a, b);

        System.out.println("La suma es: " + suma);
        System.out.println("La resta es: " + resta);
    }
}
