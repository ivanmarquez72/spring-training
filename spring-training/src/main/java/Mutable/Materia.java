package Mutable;

public class Materia {
    private String nombre;
    private int semestre;

    public Materia() {
    }

    public Materia(String nombre, int semestre) {
        this.nombre = nombre;
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
