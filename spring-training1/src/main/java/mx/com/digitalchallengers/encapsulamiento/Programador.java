package mx.com.digitalchallengers.encapsulamiento;

public class Programador extends Empleado{

    @Override
    public void publicProtected(){
        super.publicProtected();
        System.out.println("Publico a protected no se pudo");
    }

    //Los metodos pueden cambiar el modificador de acceso dando mas pero no puede disminuir

    protected void protePriv(){
        System.out.println("Protected a privado tampoco se pudo");
    }

    public void privPubl(){
        System.out.println("Private a publico");
    }
}
