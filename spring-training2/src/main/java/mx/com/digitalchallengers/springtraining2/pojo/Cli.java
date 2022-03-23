package mx.com.digitalchallengers.springtraining2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.digitalchallengers.springtraining2.entidad.Cliente;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cli implements Serializable {
    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;

    public Cliente cliToCliente(Cli client){
        Cliente cliente = new Cliente();
        cliente.setNombre(client.getNombre_cliente());
        cliente.setApellido(client.getApellido_cliente());

        return cliente;
    }

    public Cli clienteToCli(Cliente cliente){
        Cli cli = new Cli();
        cli.setId_cliente(cliente.getIdCliente());
        cli.setNombre_cliente(cliente.getNombre());
        cli.setApellido_cliente(cliente.getApellido());
        return cli;
    }


}
