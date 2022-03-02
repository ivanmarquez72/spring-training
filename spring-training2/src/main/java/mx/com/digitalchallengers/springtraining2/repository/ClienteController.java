package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.dto.FacturaCliente;
import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Controller
@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/clienteId")
    public Cliente getClienteId(){
        //List<Cliente> clientes = clienteRepository.findAll();
        Cliente cliente = clienteRepository.getClienteById(1);
        return cliente;
    }

    @GetMapping("/cliente")
    public List<Cliente> getClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @GetMapping("/facturas")
    public List<FacturaCliente> getFactura(){
        List<FacturaCliente> facturas = facturaRepository.getFacturaByClienteIdJPQL();
        return facturas;
    }

    @GetMapping("/facturasId")
    public List<Factura> getFacturaByClienteId(){
        List<Factura> facturas = facturaRepository.getFacturaByClienteId(6);
        return facturas;
    }

}
