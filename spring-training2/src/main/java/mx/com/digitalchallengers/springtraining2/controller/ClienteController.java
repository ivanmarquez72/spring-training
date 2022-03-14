package mx.com.digitalchallengers.springtraining2.controller;

import lombok.extern.slf4j.Slf4j;
import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Result;
import mx.com.digitalchallengers.springtraining2.entidad.ResultCliente;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.QueryParam;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
    public ClienteController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public Result getApi(){
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        Result result = restTemplate.getForObject(url, Result.class);
        log.info("Result " + result);
        return result;
    }

    @GetMapping("/test/list")
    public ResultCliente getList(){
        String url = "https://jsonplaceholder.typicode.com/todos/1";
        String url1 = "http://localhost:8080/clientes/1";
        Result result = restTemplate.getForObject(url, Result.class);
        Cliente cliente = restTemplate.getForObject(url1, Cliente.class);
        ResultCliente resultCliente = new ResultCliente();
        resultCliente.setCliente(cliente);
        resultCliente.setResult(result);
        return resultCliente;
    }


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
