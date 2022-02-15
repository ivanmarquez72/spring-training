package Mutable;

import Mutable.Materia;

public final class Alumno {

    private final String nombre;
    private final int age;
    private final double numeroCuenta;
    private final Materia materia;

    public Alumno(String nombre, int age, double numeroCuenta, Materia materia) {
        this.nombre = nombre;
        this.age = age;
        this.numeroCuenta = numeroCuenta;
        Materia clon = new Materia();
        clon.setNombre(materia.getNombre());
        clon.setSemestre(materia.getSemestre());
        this.materia = clon;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAge() {
        return age;
    }

    public double getNumeroCuenta() {
        return numeroCuenta;
    }

    public Materia getMateria() {
        Materia clon = new Materia();
        clon.setNombre(this.materia.getNombre());
        clon.setSemestre(this.materia.getSemestre());
        return clon;
    }
}
