package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PessoaTest {

    @Test
    void validarCalculoIdade() {
//        Pessoa pessoa = new Pessoa("Joao", LocalDate.of(2000, 1, 1).atStartOfDay());
        Pessoa pessoa = new Pessoa("Joao", LocalDateTime.of(2000, 1, 1, 15, 0, 0));

//        Assertions.assertEquals(2, pessoa.getIdade());
        Assertions.assertEquals(22, pessoa.getIdade()); //espero que o objeto chamado tenha idade de 22 anos
    }

    @Test //essa anotação é necessária pra testar
    void retornarSeEMaiorIdade() {
        Pessoa pessoa = new Pessoa("Joao", LocalDateTime.of(2000, 1, 1, 15, 0, 0));
        Assertions.assertTrue(pessoa.ehMaiorDeIdade());

        Pessoa pedro = new Pessoa("Pedro", LocalDateTime.now());
        Assertions.assertFalse(pedro.ehMaiorDeIdade());
    }
}
