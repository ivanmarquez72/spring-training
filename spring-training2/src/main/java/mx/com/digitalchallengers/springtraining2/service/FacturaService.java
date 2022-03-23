package mx.com.digitalchallengers.springtraining2.service;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.pojo.Cli;
import mx.com.digitalchallengers.springtraining2.pojo.Fac;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import mx.com.digitalchallengers.springtraining2.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    public void facturaClienteValidator(Fac fac, int id){
        Cliente cliente = clienteRepository.getClienteById(id);

        if(id == 0 || cliente == null){
            Cli client = fac.getInfo_cli();
            cliente = new Cliente();
            cliente.setNombre(client.getNombre_cliente());
            cliente.setApellido(client.getApellido_cliente());

            List<Factura> facturas = new ArrayList<>();
            facturas = cliente.getFacturas();
            facturas.add(fac.facToFactura(fac));
            cliente.setFacturas(facturas);

            clienteRepository.save(cliente);
            facturaRepository.save(fac.facToFactura(fac));
        }else{
            List<Factura> facturas = new ArrayList<>();
            facturas = cliente.getFacturas();
            facturas.add(fac.facToFactura(fac));
            cliente.setFacturas(facturas);

            clienteRepository.save(cliente);
            facturaRepository.save(fac.facToFactura(fac));
        }
//        Cliente cliente = clienteRepository.getClienteById(id);
//        List<Factura> facturas = new ArrayList<>();
//        if (cliente == null){
//            Cliente clienteNuevo = factura.getCliente();
//            facturas.add(factura);
//            clienteNuevo.setFacturas(facturas);
//            clienteRepository.save(clienteNuevo);
//            return clienteNuevo;
//        }else{
//            factura.setCliente(cliente);
//            facturas.add(factura);
//            cliente.setFacturas(facturas);
//            clienteRepository.save(cliente);
//            return cliente;
//        }

//        Cliente cliente = clienteRepository.getClienteById(id);
//        if(cliente == null){
//            cliente = factura.getCliente();
//            clienteRepository.save(cliente);
//        }
//        System.out.println(cliente);
//        factura.setCliente(cliente);
//        facturaRepository.save(factura);
//        return factura;


//        Cliente cliente = new Cliente();
//        Factura factura1 = new Factura();
//        //Saber si el cliente existe con el id que se le da por medio de la url
//        cliente = clienteRepository.getClienteById(id);
//        if(id > 0 && cliente != null){
//            factura1.setReferenciaFactura(factura.getRe_fact());
//            factura1.setFecha(factura.getFe_fact());
//            factura1.setCliente(cliente);
//
//            facturaRepository.save(factura1);
//            return factura1;
//        }else{
//            Cli client = factura.getInfo_cli();
//            cliente.setNombre(client.getNombre_cliente());
//            cliente.setApellido(client.getApellido_nombre());
//            clienteRepository.save(cliente);
//
//            factura1.setReferenciaFactura(factura.getRe_fact());
//            factura1.setFecha(factura.getFe_fact());
//            factura1.setCliente(cliente);
//
//            facturaRepository.save(factura1);
//            return factura1;
//        }
    }

    public void deleteFactura(int idCliente, int idFactura){
        Cliente cliente = clienteRepository.getClienteById(idCliente);

    }
}
