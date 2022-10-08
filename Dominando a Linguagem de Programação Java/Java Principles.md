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
    - estrutura de prevenção de erros ou direcionamento de exceções.
    - entradas erradas, falta de addos, etc.
    - NullPointerException (quando tentamos obter alguma info. de uma var nula)
    - ArithmeticException (quando tentamos dividir um valor por zero)
    - SQLException (quando existe algum erro relacionado com a interacao com o banco de dados)
    - FileNotFoundException (quando tentamos ler ou escrever em um arquivo que não existe)
      - Hierarquia de exceções
      - Java possui uma variedade de classes que representam exceções, que são organizadas em 2 categorias **Checked and Unchecked Exceptions**
  <img src="https://arquivo.devmedia.com.br/artigos/Thiago_Varallo/Excecoes_Java/Excecoes_Java2.jpg" alt="hierarchy" style="height: 400px; width:80%;"/>

  <br>

  - O risco de uma exceção ser disparada é o que define se ela será "checada" ou "não checada". A capacidade de prever se ela irá ocorrer ou não. As trataivas "checked" indicam que, ao chamar um método, determina que voce precisa tratar algum erro imediatamente.
  - RunTimeExceptions são erros em tempo de execução, que poderiam ou não ocorrer.
  - Exceções usam o "throws" 
  
## Collections  
  - É um objeto que agrupa multiplos elementos (variáveis primitivas ou objetos) dentro de uma única unidade.
  - Serve para armazenar e processar conjuntos de dados de forma eficiente.
  - Composição de uma Collection:
    - Interfaces: É um contrato que define como a classe será implementada.
    - Implementações ou Classes: são as materializações, a codificação das interfaces.
    - Algoritmos: sequencia logica e definida de intruções para resolver o problema.
    - LIST (ArrayList , LinkedList)
    - SET  (HashSet, LinkedHashSet)
    - MAP  (HashMap, LinkedHashMap)

  ### 👽 java.util.List 
  - permite elementos duplicados e garante ordem de inserção
  - **ArrayList** deve ser usado onde mais operações de <u>pesquisa</u> são necessárias. (as mais utilizadas)
    - usa array
    - remover elementos da lista é mais custoso
  - **LinkedList** deve ser usado onde mais operações de <u>inserção e exclusão</u> são necessárias.
    - usa lista ligada
    - remover ou inserir é mais rápido

    ####  Comparator x Comparable
    - Um objeto **Comparable** é capaz de se comparar com outro objeto. A própria classe deve implementar a interface java.lang.Comparable para comparar suas instâncias. 
    - Ao contrário de Comparable, **Comparator** é externo ao tipo de elemento que estamos comparando. É uma aula separada. Criamos várias classes separadas (que implementam Comparator) para comparar por membros diferentes.
    A classe Collections tem um segundo método sort() e usa Comparator. O método sort() invoca o compare() para classificar objetos. Usado quando o Comparable ja foi implementado

  ### 👽 java.util.Set
  - não permite elementos duplicados
  - não possui indice
  - HashSet, LinkedHashSet, TreeSet
    - hashCode e equals andam juntos! Se você implementar um DEVE fazer o mesmo com o outro. Não vai dar erro se não o fizer, mas a chance de alguma lógica dar errado por conta disso é muito grande.
    - A comparação de objetos é feita através do resultado do método equals() . A implementação correta do hashCode() é aquela que sempre retorna o mesmo valor quando chamado para um mesmo objeto, de acordo com o contrato do hashCode().
    - HashSet atribui os elementos aleatoriamente dentro do Set. 
    - LinkedHashSet nos permite trabalhar com ordem dos elementos inseridos, afinal ele insere cada nodo como um elemento em uma lista ligada.(trabalha com a ordem de inserção)
    - TreeSet atribui os elementos em forma de arvore, dessa forma eles aparecem ordenados de acordo com um criterio de **ordem natural**, devinido atraves do "Comparable" da classe respectiva. 

  ### java.util.Map
  - Elementos únicos(key) para cada valor. Atribuição chave/valor. 
  - Chaves NÃO PODEM SER REPETIDAS.
  - HashMap (O(1) para get, put, containsKey e remove)
  - LinkedHashMap(O(1) para get, put, containsKey e remove)
  - TreeMap(O(log n) para get, put, containsKey e remove)
  - Set<Map.Entry<K,V>>	entrySet() - Retorna uma Setvisualização dos mapeamentos contidos neste mapa. Para lidar com valores isolados dentro do mapa.
  - keySet() - Retorna uma Setvisualização das **chaves** contidas neste mapa.(Set<>)
  - values() - Retorna uma Collectionvisualização dos **valores** contidos neste mapa. (Collection<>)

  ###  (Stream)
  - Classe anonima 
    - Em Java, é uma classe que não recebeu um nome e é tanto declarado  e intanciado em uma unica instrução. Considere o uso dessa classe quando voce precisar criar uma classe que sera instanciada apenas uma vez. Ao inves de voce criar um "new funcao" atribuindo a uma variavel, voce ja instacia a mesma com todo o corpo da execução.
  - Functional Interface
    - Qualquer interface com um SAM (Single Abstract Method) é uma interface funcional e sua implementação pode ser tratada como expressões lambda.
    - Comparator
    - Consumer
    - Function
    - Predicate
    - ActionListener também é uma Interface Funcional, porém sem a notação @FunctionalInterface
  - Lambda
    - Uma função lambda é uma função sem declaração, isto é, não é necessário colocar um nome, um tipo de retorno e o modificador de acesso. A ideia é que o método seja declarado no mesmo lugar em que será usado. As funções lambda em Java tem a sintaxe definida **como (argumento) -> (corpo)**.
    - É como se fosse a simplificação de uma classe anonima.
  - Reference Method
    - Method Reference é um novo recurso do Java 8 que permite fazer referência a um método ou construtor de uma classe (de forma funcional) e assim indicar que ele deve ser utilizado num ponto específico do código, deixando-o mais simples e legível . Para utilizá-lo, basta informar uma classe ou referência seguida do símbolo “::” e o nome do método sem os parênteses no final.
    - Uma forma de simplificar o Lambda.
  - Streams API
    - A Streams API traz uma nova opção para a manipulação de coleções em Java seguindo os princípios da programação funcional. Combinada com as expressões lambda, ela proporciona uma forma diferente de lidar com conjuntos de elementos, oferecendo ao desenvolvedor uma maneira simples e concisa de escrever código que resulta em facilidade de manutenção e paralelização sem efeitos indesejados em tempo de execução.
    - SOURCE -> PIPELINE -> TERMINAL  
