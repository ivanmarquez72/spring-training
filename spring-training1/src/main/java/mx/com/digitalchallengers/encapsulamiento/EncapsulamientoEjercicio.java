package mx.com.digitalchallengers.encapsulamiento;

import org.springframework.stereotype.Service;

@Service
public class EncapsulamientoEjercicio {
    private Empleado emp1 = new Empleado();
    private Empleado prog = new Programador();
    private Empresa empresa = new Empresa();



    public void nuevoEmpleado(){
        emp1.setNombre("Ivan");
        emp1.setApellido("Lombardini");
        emp1.setMatricula(123456);
        emp1.setSueldo(123);
        System.out.println("El empelado " + emp1.getNombre() +
                " con matricula " + emp1.getMatricula() +
                " trabja en " + emp1.getEmpresa());
        System.out.println(emp1.toString());
    }

    //Los metodos heredados solo pueden dar mayor acceso, pero no menor
    //private -> protected -> public

    public void agregarEmpleado(Empleado emp){
        //Sobrecarga de Metodos
        System.out.println(prog.getEmpresa());
        prog.publicProtected();
        empresa.añadirEmpleado(emp1);
        empresa.añadirEmpleado("Rogelio", "Corona", 12345, 98765);
        empresa.imprimirLista();
        System.out.println("--------");
        empresa.imprimirLista(2);
    }
}
