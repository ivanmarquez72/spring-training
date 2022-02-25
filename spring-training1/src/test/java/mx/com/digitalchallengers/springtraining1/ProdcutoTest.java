package mx.com.digitalchallengers.springtraining1;

import mx.com.digitalchallengers.nativeSQL.Producto;
import mx.com.digitalchallengers.nativeSQL.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProdcutoTest {

    @Autowired
    private ProductoRepository productoRepository;

    @Test
    public void allProducts(){
        List<Producto> productos = productoRepository.findAll();
        productos.forEach(System.out::println);
    }


}
