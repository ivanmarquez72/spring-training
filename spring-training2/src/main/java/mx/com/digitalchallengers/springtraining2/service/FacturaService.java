package mx.com.digitalchallengers.springtraining2.service;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import mx.com.digitalchallengers.springtraining2.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    public Factura facturaClienteValidator(Factura factura, int id){
        Cliente cliente = new Cliente();
        Factura factura1 = new Factura();
        cliente = clienteRepository.getClienteById(id);
        if(id > 0 && cliente != null){
            factura1.setReferenciaFactura(factura.getReferenciaFactura());
            factura1.setFecha(factura.getFecha());
            factura1.setCliente(cliente);

            facturaRepository.save(factura1);
            return factura;
        }else{
            cliente = factura.getCliente();
            clienteRepository.save(cliente);

            factura1.setReferenciaFactura(factura.getReferenciaFactura());
            factura1.setFecha(factura.getFecha());
            factura1.setCliente(cliente);

            facturaRepository.save(factura1);
            return factura;
        }
    }

    public void deleteFactura(int idCliente, int idFactura){
        Cliente cliente = clienteRepository.getClienteById(idCliente);

    }
}
