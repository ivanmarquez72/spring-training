package mx.com.digitalchallengers.mutable;

import org.springframework.stereotype.Service;

@Service
public class MutableEjercicio {
    Materia materia = new Materia("Programacion", 5);

    public void mutableEjercicio(){
        //Mutable
        System.out.println("Primera declaracion: " + materia.getNombre());
        materia.setNombre("Spring");
        materia.setSemestre(6);
        System.out.println("Materia: " + materia.getNombre() + ", semestre: " + materia.getSemestre());

        }

    public void inmutableEjercicio(){
        //Inmutable
        Alumno alumno = new Alumno("Ivan", 22, 32144, materia);
        System.out.println("Materia antes de modificar: " + alumno.getMateria().getNombre());
        materia.setNombre("BD2");
        //Se Tiene que modificar el constructor para que al modificar el objeto de materia, no modifique
        //el valor que ya se tiene en alumno
        System.out.println("Materia despues de modificar: " + alumno.getMateria().getNombre());
        alumno.getMateria().setNombre("Estructura de Datos");
        //Se modifica el getMateria en alumno para que al darle el valor inicial este ya no cambie
        System.out.println("Materia despues de modificar: " + alumno.getMateria().getNombre());
    }
}
