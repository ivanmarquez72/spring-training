package mx.com.digitalchallengers.springtraining2.repository;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void saveCliente(){
        Cliente cliente = Cliente.builder()
                .nombre("Rogelio")
                .apellido("Corona")
                .build();
        clienteRepository.save(cliente);
    }

    @Test
    public void printAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        System.out.println("clientes: " + clientes);
        System.out.println();
        clientes.forEach(System.out::println);
    }

    @Test
    public void printClientePorNombre(){
        List<Cliente> clientes = clienteRepository.findByNombre("scoot");

        clientes.forEach(System.out::println);
    }

    @Test
    public void printClientePorId(){
        Cliente cliente = clienteRepository.getClienteById(6);
        System.out.println("Cliente: " + cliente);
    }

    @Test
    public void printClienteApellidoPorId(){
        String apellido = clienteRepository.getClienteApellidoById(10);
        System.out.println("Cliente Apellido:  " + apellido);
    }

    @Test
    public void printGetClienteByName(){
        Cliente cliente = clienteRepository.getClienteByName("Mike");
        System.out.println();
        System.out.println("Cliente: " + cliente);
        System.out.println();
    }

    @Test
    public void printGetClienteByNameParam(){
        Cliente cliente = clienteRepository.getClienteByNameParam("Mike");
        System.out.println();
        System.out.println("Cliente: " + cliente);
        System.out.println();
    }
}