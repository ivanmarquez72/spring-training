package mx.com.digitalchallengers.jdbcEjercicio;

import javax.sql.DataSource;
import java.util.List;

public interface ClienteDAO {
    public void setDataSource(DataSource ds);
    public List<Cliente> clienteLista();


}
