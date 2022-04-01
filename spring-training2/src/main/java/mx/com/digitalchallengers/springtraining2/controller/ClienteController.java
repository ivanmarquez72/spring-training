package mx.com.digitalchallengers.springtraining2.controller;

import lombok.extern.slf4j.Slf4j;
import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.entidad.Result;
import mx.com.digitalchallengers.springtraining2.entidad.ResultCliente;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import mx.com.digitalchallengers.springtraining2.repository.FacturaRepository;
import mx.com.digitalchallengers.springtraining2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.QueryParam;
import java.util.List;

@Service
@Controller
@RestController
@Slf4j
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    private RestTemplate restTemplate;

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    public ClienteController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/testSingle")
    public Result getApi(){
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        Result result = restTemplate.getForObject(url, Result.class);
        log.info("Result " + result);
        return result;
    }

    //Llamar a otro servicio
    @GetMapping("/test")
    public ResultCliente getList(){
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        String url1 = "http://localhost:8080/clientes/1";
        Result result = restTemplate.getForObject(url, Result.class);
        log.info("Result " + result);
        Cliente cliente = restTemplate.getForObject(url1, Cliente.class);
        log.info("Cliente " + cliente);
        ResultCliente resultCliente = new ResultCliente();
        resultCliente.setCliente(cliente);
        resultCliente.setResult(result);
        log.info("Cliente Result " + resultCliente);
        return resultCliente;
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        List<Cliente> clientes = clienteRepository.getAllClientes();
        return clientes;
    }

    @GetMapping("/clientes/{id}")
    public Cliente getClienteId(@PathVariable(value = "id") int id){
        Cliente cliente = clienteRepository.getClienteById(id);
        return cliente;
    }

    @Transactional
    @DeleteMapping("/clientes/{id}")
    public void deleteCliente(@PathVariable(value = "id") int id){
        Cliente cliente = clienteRepository.getClienteById(id);
        List<Factura> facturas = cliente.getFacturas();

        for (Factura factura: facturas) {
            productoRepository.eliminarFacturaProducto(factura.getIdFactura());
            facturaRepository.eliminarFacturaPorCliente(cliente.getIdCliente());
        }
        clienteRepository.deleteById(id);
    }

    @PostMapping(value = "/clientes",consumes = "application/json")
    public Cliente createCliente(@RequestBody Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    @PatchMapping(value = "/clientes/{id}", consumes = "application/json")
    public Cliente updateClienteNombre(@PathVariable(value = "id") int id, @RequestBody Cliente cliente1){
        Cliente cliente = clienteRepository.getClienteById(id);
        cliente.setNombre(cliente1.getNombre());
        clienteRepository.save(cliente);
        return cliente;
    }

    @PutMapping(value = "/clientes/{id}", consumes = "application/json")
    public Cliente updateCliente(@PathVariable(value = "id") int id, @RequestBody Cliente cliente){
        return clienteRepository.findById(id)
                .map(cliente1 -> {
                    cliente1.setNombre(cliente.getNombre());
                    cliente1.setApellido(cliente.getApellido());
                    return clienteRepository.save(cliente1);
                })
                .orElseGet(()-> {
                    return clienteRepository.save(cliente);
                } );
    }

    @PutMapping(value = "/clientes", consumes = "application/json")
    public Cliente updateClienteNombreApellido(@RequestBody Cliente cliente,
                                               @QueryParam("nombre") String nombre,
                                               @QueryParam("apellido") String apellido){
        Cliente cliente2 = clienteRepository.getClienteByNombreAndApellido(nombre, apellido);

        return clienteRepository.findById(cliente2.getIdCliente())
                .map(cliente1 -> {
                    cliente1.setNombre(cliente.getNombre());
                    cliente1.setApellido(cliente.getApellido());
                    return clienteRepository.save(cliente1);
                })
                .orElseGet(()-> {
                    return clienteRepository.save(cliente);
                } );
    }

}
