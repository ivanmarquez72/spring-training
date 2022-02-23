package mx.com.digitalchallengers.jdbcEjercicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "mx.com.digitalchallengers.jdbcEjercicio")
public class SpringConfiguration {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/springTraining");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        return dataSource;
    }
}
