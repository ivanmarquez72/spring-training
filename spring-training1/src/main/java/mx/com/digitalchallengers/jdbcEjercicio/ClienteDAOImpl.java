package mx.com.digitalchallengers.jdbcEjercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteDAOImpl implements  ClienteDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Cliente> clienteLista(){
        String sql = "select * from cliente;";
        return this.jdbcTemplate.query(sql, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int i) throws SQLException {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                return cliente;
            }
        });
    }
}
