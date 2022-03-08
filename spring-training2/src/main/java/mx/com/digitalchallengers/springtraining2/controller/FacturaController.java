package mx.com.digitalchallengers.springtraining2.controller;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Controller
@RestController
public class FacturaController {

    @Autowired
    private FacturaRepository facturaRepository;

    @GetMapping("/facturasId")
    public List<Factura> getFactura(){
        List<Factura> facturas = facturaRepository.getFacturaByClienteIdJPQL();
        return facturas;
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
