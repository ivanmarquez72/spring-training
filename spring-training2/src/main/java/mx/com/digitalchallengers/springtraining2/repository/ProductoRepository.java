package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.FacturaProductos;
import mx.com.digitalchallengers.springtraining2.entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("select p from Producto p where p.nombre = ?1")
    Producto getProductoByNombre(String name);

    @Query("select p from Producto p where p.idProducto = ?1")
    Producto getProductoById(int id);

    @Query(
            value = "delete from factura_producto " +
                    "where id_producto = :idProducto ",
            nativeQuery = true
    )
    void  deleteProductFactura(@Param("idProducto")int idProducto);

    @Query(
            value = "delete from factura_producto " +
                    "where id_producto = :idProducto " +
                    "and factura_id = :idFactura",
            nativeQuery = true
    )
    void deleteProductFactura(@Param("idProducto") int idProducto,
                              @Param("idFactura") int idFactura);

    @Query(
            value = "select factura_id, id_producto from factura_producto " +
                    "where id_producto = :idProducto " +
                    "and factura_id = :idFactura",
            nativeQuery = true
    )
    FacturaProductos exiteProductFactura(@Param("idProducto") int idProducto,
                                         @Param("idFactura") int idFactura);

}
