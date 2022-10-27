package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CamposObrigatoriosException;
import dio.web.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User usuario) {
        System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }

    public void update(User usuario) {
        // esse padrao agrupa a validação em uma nova classe que extende o BusinessException e reutiliza nos campos necessários
        if(usuario.getLogin() == null)
            throw  new CamposObrigatoriosException("login");
        if(usuario.getPassword() == null)
            throw  new CamposObrigatoriosException("password");
//            throw  new BusinessException("O campo login é obrigatório"); // exceção criada manualmente para tratar o status de erro
//            throw  new RuntimeException("O campo login é obrigatório"); // exceção padrão, nao intuitiva para o usuario
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }

    public void remove(Integer id) {
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }

    public List<User> findAll() {
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User("gleyson", "password"));
        usuarios.add(new User("frank", "masterpass"));
        return usuarios;
    }

    public User finById(Integer id) {
        System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
        return new User("gleyson", "password");
    }

    public User finByUsername(String username) {
        System.out.println(String.format("GET/username - Recebendo o username: %s para localizar um usuário", username));
        return new User("gleyson", "password");
    }
}
