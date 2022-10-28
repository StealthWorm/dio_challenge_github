package dio.spring.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome(){
        return "Welcome to My Spring Boot Web API";
    }
    @GetMapping("/users")
//    @PreAuthorize("hasRole('MANAGERS', 'USERS')") // definindo as roles que cada rota vai permitir a visualização, nesse caso as roles users e managers podem acessr a rota /users
    public String users() {
        return "Authorized user";
    }
    @GetMapping("/managers")
//    @PreAuthorize("hasRole('MANAGERS')")
    public String managers() {
        return "Authorized manager";
    }
}
