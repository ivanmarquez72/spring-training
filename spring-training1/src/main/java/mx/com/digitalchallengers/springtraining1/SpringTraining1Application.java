package mx.com.digitalchallengers.springtraining1;

import mx.com.digitalchallengers.jdbcEjercicio.Cliente;
import mx.com.digitalchallengers.jdbcEjercicio.ClienteDAO;
import mx.com.digitalchallengers.jdbcEjercicio.ClienteDAOImpl;
import mx.com.digitalchallengers.jdbcEjercicio.SpringConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringTraining1Application{

    public static void main(String[] args) {
        SpringApplication.run(SpringTraining1Application.class, args);

        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ClienteDAO cliente = ctx.getBean(ClienteDAO.class);
        List<Cliente> clientes = cliente.clienteLista();

        clientes.forEach(System.out::println);
    }

    //Tiene que estar en el mismo paquete para que pueda correr bien la aplicacion
    @Autowired
    //inyeccion
    private Empleado empleado;

    @Autowired
    private HelloController hello;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            //escuela();
            empleado.historia();
            hello.index();
            System.out.println("Let's inspect the beans provided by Spring Boot!: ");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName: beanNames) {
                System.out.println(beanName);
            }
        };
    }

    public void run(String... args) throws Exception {
        String sql = " insert into producto (nombre, precio) " +
                "values (?, ?); ";

        int result =  jdbcTemplate.update(sql,"Spiderman toy","16" );

        if (result > 0 ){
            System.out.println("Connection achieve");
        }

    }


}
