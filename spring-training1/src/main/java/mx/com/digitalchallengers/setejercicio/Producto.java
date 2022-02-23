package mx.com.digitalchallengers.setejercicio;

import java.util.Objects;

public class Producto implements Comparable<Producto>{
    private String nombre;
    private int cantidad;

    Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return cantidad == producto.cantidad && nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantidad);
    }

    @Override
    public int compareTo(Producto producto) {
        //return this.nombre.compareTo(producto.nombre);
        int i = nombre.compareTo(producto.nombre);
        if(i != 0 ) return i;

        return Integer.compare(cantidad, producto.cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
