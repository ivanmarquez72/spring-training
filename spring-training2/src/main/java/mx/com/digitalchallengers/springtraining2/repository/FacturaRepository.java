package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
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
    @Query("select f " +
            "from Factura f join f.cliente c where c.idCliente = 1")
    List<Factura> getFacturaByClienteIdJPQL();
}
