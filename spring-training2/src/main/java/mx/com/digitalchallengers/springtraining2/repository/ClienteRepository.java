package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Integer> {

    public List<Cliente> findByNombre(String nombre);

    //JPQL
    @Query("select c from Cliente c where c.idCliente = ?1")
    Cliente getClienteById(int id);

    //JPQL
    @Query("select c.apellido from Cliente c where c.idCliente = ?1")
    String getClienteApellidoById(int id);

    //Native Query
    @Query(
            value = "select * from cliente c where c.nombre = ?1",
            nativeQuery = true
    )
    Cliente getClienteByName(String name);

    //Native Named Param
    @Query(
            value = "select * from cliente c where c.nombre = :name",
            nativeQuery = true
    )
    Cliente getClienteByNameParam(@Param("name")String name);

    @Query(value = "select c from Cliente c")
    List<Cliente> getAllClientes();

    //@Query(value = "")

    @Query(value = "select c.idCliente from Cliente c  where :nombre = c.nombre")
    int getIdClienteByNombre(@Param("nombre") String nombre);

    @Query(value = "select c from Cliente c  where :nombre = c.nombre")
    List<Cliente> getClientesByNombre(@Param("nombre") String nombre);

    @Query(value = "select c from Cliente c  where :nombre = c.nombre and :apellido = c.apellido")
    List<Cliente> getClientesByNombreAndApellido(@Param("nombre") String nombre,
                                                 @Param("apellido") String apellido);

    @Query(value = "select c from Cliente c  where :nombre = c.nombre and :apellido = c.apellido")
    Cliente getClienteByNombreAndApellido(@Param("nombre") String nombre,
                                          @Param("apellido") String apellido);

}
