package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    //Native Named Param
    @Query(
            value = "select * " +
                    "from factura f join  " +
                        "(select * from cliente where id_cliente = :idCliente) c " +
                    "on f.cliente_id_cliente = c.id_cliente",
            nativeQuery = true
    )
    List<Factura> getFacturaByClienteId(@Param("idCliente")int idCliente);

    //JPQL
    @Query("select f from Factura f join f.cliente c where c.idCliente = :id")
    List<Factura> getFacturaByClienteIdJPQL(int id);

    @Query("select f from Factura f where f.cliente.idCliente = :id and f.fecha = :fecha")
    List<Factura> getFacturaByNombreAndFecha(int id, String fecha);

    @Query("select f from Factura f where f.cliente.idCliente = :id and f.referenciaFactura = :referencia")
    Factura getFacturaByIdClienteAndReferencia(int id, String referencia);

    @Query("select f from Factura f where f.referenciaFactura = :referencia")
    Factura getFacturaByReferencia(String referencia);

    @Query(
            value = "delete from factura_producto " +
                    "where id_producto = :idProducto " +
                    "and factura_id = :idFactura",
            nativeQuery = true
    )
    void  getClienteByNameParam(@Param("idProducto")int idProducto,
                                @Param("idFactura")int idFactura);

    @Modifying
    @Query(value = "delete from factura where cliente_id_cliente = :idCliente",
            nativeQuery = true)
    void eliminarFacturaPorCliente(@Param("idCliente") int idCliente);
}
