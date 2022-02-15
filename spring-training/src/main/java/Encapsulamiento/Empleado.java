package Encapsulamiento;

public class Empleado {
    private String nombre;
    private String apellido;
    private int matricula;
    private double sueldo;
    String empresa = "Digital Challengers";

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, int matricula, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "Encapsulamiento.Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula=" + matricula +
                ", sueldo=" + sueldo +
                '}';
    }

    /* padre con el metodo publico y el hijo lo cambiamos a protected
     *
     *  padre metodo protected y el hijo cambiar a privado
     *
     *  padre privado y el hijo publico
     *
     * */

    public void publicProtected(){
        System.out.println("Publico a protected");
    }

    protected void protePriv(){
        System.out.println("Protected a privado");
    }

    private void privPubl(){
        System.out.println("Private a publico");
    }



}
