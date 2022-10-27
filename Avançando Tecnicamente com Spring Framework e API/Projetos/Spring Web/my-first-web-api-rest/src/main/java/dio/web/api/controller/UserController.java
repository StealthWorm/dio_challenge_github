package dio.web.api.controller;

import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// o controller é como um proxy que direciona o caminho para as requisições
// o endpoint delega a responsabilidade para outro componente, nesse caso localizado no repository
@RestController
@RequestMapping("/users") // centralizar um prefixo, diz que todas as requisições nesse controller começam com "users"
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping()
    public void post(@RequestBody User usuario){
        repository.save(usuario);
    }

    @PutMapping()
    public void put(@RequestBody User usuario){
        repository.update(usuario);
    }

    @GetMapping()
    public List<User> getAll(){
        return repository.findAll();
    }

    @GetMapping("/users/{username}")
    public User getOne(@PathVariable("username") String username){
        return repository.finByUsername(username);
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable("id") Integer id){
        return repository.finById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.remove(id);
    }
}
