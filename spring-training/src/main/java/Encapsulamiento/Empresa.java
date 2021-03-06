package Encapsulamiento;

import Encapsulamiento.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados = new ArrayList<>();
    private int presupuesto = 100000;

    public Empresa() {
    }

    public List añadirEmpleado(Empleado emp){
        empleados.add(emp);
        System.out.println("Hay " + empleados.size() + " empleados en la empresa");
        return empleados;
    }

    public List añadirEmpleado(String nombre, String apellido, double sueldo, int matricula){
        empleados.add(new Empleado(nombre,apellido,matricula,sueldo));
        System.out.println("Hay " + empleados.size() + " empleados en la empresa");
        return empleados;
    }

    public int dineroDisponible(int sueldos){
        return presupuesto - sueldos;
    }

    public void imprimirLista(){
        for (Empleado empleado : this.empleados) {
            System.out.println(empleado.toString());
        }
    }

    public void imprimirLista(int numero){
        for (int i = 0; i<numero; i++)
        empleados.forEach(System.out::println);
    }

}
