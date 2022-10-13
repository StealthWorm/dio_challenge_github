package org.example;

import org.junit.jupiter.api.*;

//voce define a ordem de execuçao dos testes colocando um identificador "@Order()" sobre o identificador "@Test"
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

//a ordem dos testes respeita a ordem alfabetica "DisplayName". Tambem é possivel setar um DisplayName sobre o teste utilziando o "@DisplayName()".
// é muito util para definir nomes mais sugestivos para os testes
//@TestMethodOrder(MethodOrderer.DisplayName.class)

//a ordem dos testes é randomizada
@TestMethodOrder(MethodOrderer.Random.class)

public class EscolhendoAOrdemTeste {

    //    @Order(4)
    @DisplayName("Teste valida A")
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    //    @Order(3)
    @DisplayName("B")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    //    @Order(2)
    @DisplayName("C")
    @Test
    void validaFluxoC() {

        Assertions.assertTrue(true);
    }

    //    @Order(1)
    @DisplayName("D")
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}
