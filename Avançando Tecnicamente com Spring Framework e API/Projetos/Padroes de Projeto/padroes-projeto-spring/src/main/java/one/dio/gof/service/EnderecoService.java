package one.dio.gof.service;

import one.dio.gof.model.Endereco;

public interface EnderecoService {

    Iterable<Endereco> buscarTodos();

    Endereco buscarPorId(Long id);

    void inserir(Endereco cliente);

    void atualizar(Long id, Endereco endereco);

    void deletar(Long id);
}
