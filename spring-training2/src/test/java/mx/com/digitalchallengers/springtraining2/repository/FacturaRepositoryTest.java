package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FacturaRepositoryTest {

    @Autowired
    private FacturaRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EntityManager entityManager;

//    @Test
//    public void saveFActuraCliente(){
//        Cliente cliente = clienteRepository.getClienteById(4);
//        Factura factura = Factura
//                .builder()
//                .cliente(cliente)
//                .fecha("28/02/2022")
//                .referenciaFactura("FAC2802")
//                .build();
//
//        repository.save(factura);


    @Test
    public void getFacturasCliente(){
        TypedQuery<Factura> query = entityManager.
                createQuery("SELECT f FROM Cliente c inner join c.facturas f", Factura.class);
        List<Factura> facturas = query.getResultList();
        facturas.forEach(System.out::println);
    }
}