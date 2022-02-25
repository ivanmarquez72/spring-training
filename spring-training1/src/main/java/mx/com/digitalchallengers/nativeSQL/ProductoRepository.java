package mx.com.digitalchallengers.nativeSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    //JPQL
    @Query("select p from producto p where p.nombre = ?1")
    Producto getProductoByNameJPQL(String name);

    //Native
    @Query(
            value = "select * from producto p where p.precio = ?1;",
            nativeQuery = true
    )
    Producto getProductoByPriceNative(int precio);

    @Query(
            value = "select * from producto p where p.precio = precio;",
            nativeQuery = true
    )
    Producto getProductoByPrecioParam(@Param("precio") int precio);
}
