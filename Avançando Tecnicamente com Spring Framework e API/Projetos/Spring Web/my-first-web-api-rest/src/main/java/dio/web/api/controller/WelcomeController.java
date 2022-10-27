package dio.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping //dizendo que o método welcome é um recurso HTTP do tipo GET utilizando GetMapping
    public String welcome(){
        return "Welcome to my Spring Boot Web API";
    }
}
