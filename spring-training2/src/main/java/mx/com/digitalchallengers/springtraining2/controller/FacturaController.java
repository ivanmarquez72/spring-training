package mx.com.digitalchallengers.springtraining2.controller;

import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.entidad.FacturaProductos;
import mx.com.digitalchallengers.springtraining2.pojo.Product;
import mx.com.digitalchallengers.springtraining2.entidad.Producto;
import mx.com.digitalchallengers.springtraining2.pojo.Fac;
import mx.com.digitalchallengers.springtraining2.repository.ClienteRepository;
import mx.com.digitalchallengers.springtraining2.repository.FacturaRepository;
import mx.com.digitalchallengers.springtraining2.repository.ProductoRepository;
import mx.com.digitalchallengers.springtraining2.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ProductoRepository productoRepository;

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

    @PostMapping(value = "/facturas/{id}/productos", consumes = "application/json")
    public List<Producto> insertProductos(@PathVariable("id") int id,
                                          @RequestBody List<Product> products){

        List<Producto> productos = new ArrayList<>();
        Producto producto;
        for (Product product : products){
            producto = productoRepository.getProductoByNombre(product.getNombre());
            productos.add(producto);
        }
        Factura factura = facturaRepository.getById(id);
        factura.setProductos(productos);
        facturaRepository.save(factura);

        return productos;
    }

    @PostMapping(value = "/facturas/productos", consumes = "application/json")
    public List<Producto> insertProductosReferencia(@QueryParam("referencia") String ref,
                                                    @RequestBody List<Product> products){
        List<Producto> productos = new ArrayList<>();
        Producto producto;
        for (Product product : products){
            producto = productoRepository.getProductoByNombre(product.getNombre());
            productos.add(producto);
        }
        Factura factura = facturaRepository.getFacturaByReferencia(ref);
        factura.setProductos(productos);
        facturaRepository.save(factura);

        return productos;
    }

    @Transactional
    @DeleteMapping("/facturas/{id}")
    public void deleteFactura(@PathVariable(value = "id") int id){
        productoRepository.eliminarFacturaProducto(id);
        facturaRepository.deleteById(id);
    }

    @Transactional
    @DeleteMapping(value = "/facturas/{id}/productos", consumes = "application/json")
    public void deleteProductoFactura(@PathVariable(value = "id")int id,
                                      @RequestBody List<Product> products){

        Factura factura = facturaRepository.getById(id);
        List<Producto> productos = factura.getProductos();

        for (Producto producto: productos) {
            for (Product product : products) {
                if(producto.getNombre().equals(product.getNombre())){
                    productoRepository.deleteProductFactura(producto.getIdProducto(), id);
                }

            }
        }
    }


}
