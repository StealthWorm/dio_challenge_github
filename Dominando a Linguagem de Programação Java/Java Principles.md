## Tipos de Dado
  São valores e operações que as variáveis podem assumir e sofrer, respectivamente. 

  Estática(forte) quando a variável ja exige a tipagem no momento da sua criação / Dinamica(fraco) não é obrigada a definir o tipo

  Primitivo -> mais básicos, homogeneos, texto, numero / Composto -> ligadora a POO, heterogeneo

  Tipos
  . Textual(
    char(16 bit unicode)
    String(tipo especial)
  )
  . Numeral (
      byte(128 a 127)
      short(32.768 a 32.767)
      int(-2.147.483.648 a 2.147.483.647),
      long(-9.223.372.036.854.775.808 a 9.223.372.036.854.775.807) -> long l = 123123213L;
      float(+- 3.40282347E+38F) -> 3.14f
      double(+- 1.79769313486231570E+308) -> 3.14d
    )
  . Lógico(
    boolean
  )
  . Objeto()

## Operadores Aritméticos
  - São simbolos especiais que são capazes de realizar ações especificas em um ou mais operandos e, em seguida, retornar um resultado.

  - pós-fixado: exp++ ou exp-- (i++)
  - pré-fixado: ++exp ou --exp (++i)
  - aritmético: +, -, *, /, % (1+2, 8/4)
  - atribuição: =, +=, -=, *=, /=, %= (j -= 3 -> j = j-3)

## Conversões
  - Tranformação de uma var. de um tipo menos especifico para um tipo mais especifico.
  - Upcast(ímplicito) -> uma var de capacidade menor atribuindo para uma de capacidade maior (int i = 5; long l = i;)
  - Downcast(explicito) -> uma var de capacidade maior atribuindo para uma de capacidade menor, precisa deixar EXPLICITO o tipo(int i; long l = 100; i = (int)l)
    - Downcast pode gerar perda de valores.

## Métodos
  - Porção de código disponibilizada por uma classe, é executado quando é feita uma requisição a ele e realizam determinado comportamento. Não funciona por si só.
  - É chamado a partir de uma Classe ou de um Objeto.

  <blockquote> 
    <<"nome_da_classe">>.<<"nome_do_metodo">>();
    <<"nome_do_objeto">>.<<"nome_do_metodo">>();

    Exemplo:

    - classes, por padrão em java, possuem a primeira letra Maiúscula
      Math.random();
      Math.sqrt(4);

    - objetos, por padrão em java, possuem a primeira letra Minúscula
      usuario.getEmail();
  </blockquote>

  visibilidade (opcional) - public, private, protected
  tipo         (opcional) - concreto, abstrato
  modificador  (opcional) - static ou final
  retorno                 - tipo de dado ou void
  nome                    - nome do , método
  parametros  (opcional)  - parametros do método

  ```java
  public string getNome() {...}
  public int verificarDistancia(int coord1, int coord2) {...}
  public abstract void executar();
  ```
  #### Particularidades
  - **Assinatura: forma de identificar unicamente um método**
    - nome + parametros
    ```java
    public double calcularTotalVenda(double preco1, double preco2, double preco3) {...}

    //Assinatura
    calcularTotalVenda(double preco1, double preco2, double preco3)
    ```
  - **Contrutor e Destrutor: métodos especiais usados na Orientação a Objetos**
  - **Mensagem: ato de solicitar ao método que este execute. Pode ser direcionada a um objeto ou uma classe**
  - **Passagem de parametros**
    - Por valor(cópia)
    ```java
    int i = 10;
    public void fazerAlgo(int i) {
      i = i + 10;
      System.out.println("Valor de i dentro: " + i);
    }
    System.out.println("Valor de i fora: " + i);
    ```
    - Por referencia(endereço)
      - Mais destinado à **POO**


  #### Boas Práticas
  - Nomes sugestivos e descritivos, porém curtos
  - Notação camelo (a letra de cada Palavra após a primeira é maiúscula -> "verificarMétodoCompra()")
  - Deve possuir entre 80 e 120 linhas
  - Evitar lista de parametros longas
  - Visibilidades adequadas

## Sobrecarga
  - É a capacidade de definir métodos para diferentes contextos, mas preservando o seu nome.
  - Os métodos são diferenciados pelos parametros incluidos.
  - 
  ```java
  // a ASSINATURA de cada método é diferente
  converterParaInteiro(float f);
  converterParaInteiro(float f, RoundType rd);
  converterParaInteiro(double d);
  converterParaInteiro(String s);
  ```
  #### Sobrecarga x Sobrescrita
    - Sobrecarga mantém o nome e muda a estrutura de parametros
    - Sobrescrita tem relação com herança, um conceito da POO

## Retornos
  - "return"
  - o tipo de dado retornado deve ser compatível com o do método
  - pode ser um tipo primitivo ou objeto.
  ```java
  public string getMensagem(){
    return "Olá!" 
  }
  public double getJuros(){
    return 2.36; 
  }
  ```

  ## Estruturas de Repetição e Controle de Fluxo
  - Habilidade de ajustar a maneira como o programa executa suas tarefas. Podem ser executadas seletivamente, repetidamente ou excepcionalmente.
  - Estruturas condicionais : "if-else", "switch-case"
  - Estruturas de Repetição : "for", "while", "do-while"
    - variavel incrementada a cada iteração.
    - do-while testa a condição ao menos uma vez antes de validar a condição.
  - Estruturas de Exceções : "try-catch-finally", "throw"