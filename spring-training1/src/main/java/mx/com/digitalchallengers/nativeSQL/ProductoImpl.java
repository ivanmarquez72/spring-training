package mx.com.digitalchallengers.nativeSQL;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoImpl implements IProductoDAO {
    @Autowired
    private ProductoRepository repo;

    @Override
    public List<Producto> listaProductos() {
        System.out.println("Lista");
        return repo.findAll();
    }
}
