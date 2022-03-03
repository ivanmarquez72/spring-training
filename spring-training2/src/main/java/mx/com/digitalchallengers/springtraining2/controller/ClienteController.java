package mx.com.digitalchallengers.springtraining2.controller;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Controller
@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clienteId")
    public Cliente getClienteId(){
        //List<Cliente> clientes = clienteRepository.findAll();
        Cliente cliente = clienteRepository.getClienteById(1);
        return cliente;
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        List<Cliente> clientes = clienteRepository.getAllClientes();
        return clientes;
    }
}
