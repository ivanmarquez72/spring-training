package Set1;

import java.util.Objects;

public class Producto implements Comparable<Producto>{

    String nombre;
    int cantidad;

    Producto(String s, int i){
        nombre = s;
        cantidad = i;
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

}
