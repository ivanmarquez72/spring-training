package mx.com.digitalchallengers.springtraining2.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.com.digitalchallengers.springtraining2.entidad.Factura;
import mx.com.digitalchallengers.springtraining2.service.FacturaService;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fac implements Serializable {
    private String re_fact;
    private String fe_fact;
    private Cli info_cli;
    private List<Product> products;

    public Factura facToFactura(Fac fac){
        FacturaService service = new FacturaService();
        Factura factura = new Factura();
        factura.setCliente(fac.getInfo_cli().cliToCliente(fac.getInfo_cli()));
        factura.setReferenciaFactura(fac.re_fact);
        factura.setFecha(fac.getFe_fact());
        factura.setProductos(service.ProdToProducto(fac.products));
        return factura;
    }

    public Fac facturaToFac(Factura factura){
        Fac fac = new Fac();
        Cli cli = new Cli();
        fac.setFe_fact(factura.getFecha());
        fac.setRe_fact(factura.getReferenciaFactura());
        fac.setInfo_cli(cli.clienteToCli(factura.getCliente()));
        return fac;
    }


//    public Cliente agregarFacACliente(Fac fac, int id){
//        Cliente cliente = clienteRepository.getClienteById(id);
//        List<Factura> facturas = new ArrayList<>();
//        facturas = cliente.getFacturas();
//        facturas.add(fac.facToFactura(fac));
//        cliente.setFacturas(facturas);
//
//        return cliente;
//    }
}
