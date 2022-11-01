package one.dio.gof.service;

import one.dio.gof.model.Cliente;

// interface que define o padrão "Strategy" no dominio de cliente. Com isso podemos ter multiplas implementações dessa mesma interface
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
