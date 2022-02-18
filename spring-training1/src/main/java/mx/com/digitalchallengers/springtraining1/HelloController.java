package mx.com.digitalchallengers.springtraining1;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String index(){
        return "Greetings form Spring Boot!";
    }

}
