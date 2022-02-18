package mx.com.digitalchallengers.springtraining1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringTraining1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTraining1Application.class, args);
    }

    //Tiene que estar en el mismo paquete para que pueda correr bien la aplicacion
    @Autowired
    //inyeccion
    private Empleado empleado;

    @Autowired
    private HelloController hello;

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

    /*@Bean
    public Alumno alumno(){
        System.out.println("lets do this");
        return new Alumno("Ivan");
    }

    @Bean
    public Escuela escuela(){
        System.out.println("Hola Chicos");
        return new Escuela(alumno());
    }*/



}
