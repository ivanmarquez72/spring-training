package mx.com.digitalchallengers.springtraining2.controller;

import lombok.extern.slf4j.Slf4j;
import mx.com.digitalchallengers.springtraining2.entidad.Cliente;
import mx.com.digitalchallengers.springtraining2.entidad.Producto;
import mx.com.digitalchallengers.springtraining2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@Service
@Controller
@RestController
@Slf4j
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @PostMapping(value = "/productos",consumes = "application/json")
    public Producto createProducto(@RequestBody Producto producto){
        Producto producto1 = productoRepository.getProductoByNombre(producto.getNombre());

        if (producto1 == null){
            productoRepository.save(producto);
            return producto;
        }else{
            producto.setNombre("No se puede crear el producto, Ya existe");
            producto.setPrecio(0);
            return producto;
        }
    }

    @GetMapping("/productos")
    public List<Producto> getProducts(){
         List<Producto> productos = productoRepository.findAll();
         return productos;
    }

    @DeleteMapping("/productos/{id}")
    public Producto deleteProducto(@PathVariable(value = "id") int id){
        Producto producto = productoRepository.getProductoById(id);
        productoRepository.deleteById(id);
        return producto;
    }

    @DeleteMapping("/productos")
    public Producto deleteProductoByName(@QueryParam("nombre") String nombre){
        Producto producto = productoRepository.getProductoByNombre(nombre);
        productoRepository.deleteProductFactura(producto.getIdProducto());
        productoRepository.delete(producto);
        return producto;
    }

    @PutMapping(value = "/productos/{id}", consumes = "application/json")
    public Producto updateCliente(@PathVariable(value = "id") int id, @RequestBody Producto producto){
        return productoRepository.findById(id)
                .map(producto1 -> {
                    producto1.setNombre(producto.getNombre());
                    producto1.setPrecio(producto.getPrecio());
                    return productoRepository.save(producto1);
                })
                .orElseGet(()-> {
                    return productoRepository.save(producto);
                } );
    }

    @PutMapping(value = "/productos", consumes = "application/json")
    public Producto updateCliente(@QueryParam("nombre") String nombre, @RequestBody Producto producto){
        Producto producto1 = productoRepository.getProductoByNombre(nombre);
        if(producto1 == null){
            producto1.setNombre(producto.getNombre());
            producto1.setPrecio(producto.getPrecio());
             return productoRepository.save(producto1);
        }else{
            return productoRepository.save(producto);
        }
    }
}
