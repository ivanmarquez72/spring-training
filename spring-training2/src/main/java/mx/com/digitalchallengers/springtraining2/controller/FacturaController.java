package mx.com.digitalchallengers.springtraining2.controller;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.pojo.Cli;
import mx.com.digitalchallengers.springtraining2.pojo.Fac;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import mx.com.digitalchallengers.springtraining2.repository.FacturaRepository;
import mx.com.digitalchallengers.springtraining2.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;
import java.util.Optional;

@Service
@Controller
@RestController
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/clientes/{idCliente}/facturas")
    public List<Factura> getFactura(@PathVariable(value = "idCliente") int id){
        List<Factura> facturas = facturaRepository.getFacturaByClienteIdJPQL(id);
        return facturas;
    }

    @GetMapping("/facturasByNombre")
    public List<Factura> getFacturasFechaIdCliente(@QueryParam("nombre") String nombre,
                                                   @QueryParam("fecha") String fecha){
        int id = clienteRepository.getIdClienteByNombre(nombre);
        List<Factura> facturas = facturaRepository.getFacturaByNombreAndFecha(id, fecha);

        return facturas;
    }

    @PostMapping(value = "/clientes/{id}/facturas", consumes = "application/json")
    public void createFactura(@PathVariable("id")int id, @RequestBody Fac factura){
        facturaService.facturaClienteValidator(factura, id);
    }

//    @PostMapping(value = "/facturas", consumes = "application/json")
//    public Factura crearFactura(@QueryParam("nombre") String nombre,
//                                @QueryParam("apellido") String apellido,
//                                @RequestBody Factura factura){
//        Cliente cliente = clienteRepository.getClienteByNombreAndApellido(nombre,apellido);
//
//        factura.setCliente(cliente);
//        facturaRepository.save(factura);
//        return factura;
//    }

    @PutMapping(value = "/facturas", consumes = "application/json")
    public Factura updateFactura(@QueryParam("nombre") String nombre,
                                 @QueryParam("apellido") String apellido,
                                 @QueryParam("referencia") String referencia,
                                 @RequestBody Factura factura){

        Cliente cliente =
                clienteRepository.getClienteByNombreAndApellido(nombre,apellido);
        Factura factura1 =
                facturaRepository.getFacturaByIdClienteAndReferencia(cliente.getIdCliente(),referencia);

        return facturaRepository.findById(factura1.getIdFactura())
                .map(factura2 -> {
                    factura2.setFecha(factura.getFecha());
                    factura2.setReferenciaFactura(factura.getReferenciaFactura());
                    return facturaRepository.save(factura2);
                })
                .orElseGet(()-> {
                    return facturaRepository.save(factura);
                } );

    }

    @GetMapping("/facturasIdNative")
    public List<Factura> getFacturaByClienteId(){
        List<Factura> facturas = facturaRepository.getFacturaByClienteId(19);
        return facturas;
    }

    @GetMapping("/facturas")
    public List<Factura> getFacturas(){
        List<Factura> facturas = facturaRepository.findAll();
        return facturas;
    }
}
