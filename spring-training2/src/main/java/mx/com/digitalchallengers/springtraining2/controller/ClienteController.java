package mx.com.digitalchallengers.springtraining2.controller;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@Service
@Controller
@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes/{id}")
    public Cliente getClienteId(@PathVariable(value = "id") int id){
        Cliente cliente = clienteRepository.getClienteById(id);
        return cliente;
    }

    @GetMapping("/clientes/byNombre")
    public List<Cliente> getClienteNombre(@QueryParam("nombre") String nombre){
        //List<Cliente> clientes = clienteRepository.findAll();
        List<Cliente> clientes = clienteRepository.getClientesByNombre(nombre);
        return clientes;
    }

    @GetMapping("/clientes/byNombreAndApellido")
    public List<Cliente> getClientesNombreAndApellido(@QueryParam("nombre") String nombre,
                                                     @QueryParam("apellido") String apellido){
        //List<Cliente> clientes = clienteRepository.findAll();
        List<Cliente> clientes = clienteRepository.getClientesByNombreAndApellido(nombre,apellido);
        return clientes;
    }

    @DeleteMapping("/clientes/{id}/remove")
    public void deleteCliente(@PathVariable(value = "id") int id){
        clienteRepository.deleteById(id);
    }

    @PostMapping(value = "/clientes/createClientes",consumes = "application/json")
    public Cliente createCliente(@RequestBody Cliente cliente){
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


    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        List<Cliente> clientes = clienteRepository.getAllClientes();
        return clientes;
    }
}
