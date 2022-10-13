## Testes Unitários
  Testa a menor unidade do código possível (funções, classes, métodos).
  Serve para correção de bugs, compreensão do código fonte, melhorias na segurança.

  - Para o Java existe o JUnit
  - Framework opensource de testes
    - JUnit Platform (componente que executa os testes)
    - JUnit Jupiter (notations, classes e repos)
    - JUnit Vintage(motor para fazer integração com versões mais antigas do JUnit)

  - Os teste executados sempre usam o Junit-jupiter-engine
  - utilizar a extensão apropriada para cada lib (se vc criou o projeto usando maven ou gradle)
  - para o **maven** voce adiciona o trecho abaixo no "pom" na parte de dependencias
  ```java
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.8.2</version>
        <scope>test</scope>
    </dependency>
  ```

  - para o **gradle** voce adiciona o trecho abaixo no "build.gradle" na parte de dependencias
  ```java
    testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: '5.8.2'
  ```
  ### Exemplo de teste unitário
  ```java
    class Pessoa {
      //construtor, métodos e atributos

      public boolean eMaiorDeIdade() {
        return idade > 18;
      }
    }

    class PessoaTeste {
      @Test
      void validaVerificacaoMaiorIdade() {
        Pessoa joao = new Pessoa("Joao", LocalDate.of(2004, 1, 1));
        Assertions.assertTrue(joao.eMaiorDeIdade());
      }
    }
  ```

  - Os códigos de teste são escritos na árveore de testes , uma pasta dentro do projeto criado.

## Boas Práticas
- Buscar simplicidade (nomes sugestivos e com preocupação na leitura do teste).
- Comece a tetsra cedo, proximo do codigo de execução.
- TDD
- Buscar padronização (nomenclaturas)
- Testes precisam ser determinísticos 
- Automatize (ferramentas de cobertura de código)