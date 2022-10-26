package dio.springboot.app;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    // Gson é uma lib externa é nao possui o "@Component", por isso é preciso criar uma estrutura pra declarar ele como um @Bean
    //Nesse caso foi criada a classe como "@Component" e setada a instancição do Gson como um Bean
    @Bean
    public Gson gson(){
        return new Gson();
    }
}
