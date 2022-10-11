## POO
  - É um paradigma de análise, projeto e programação de sistemas baseado na composição e interação ente diversas unidades de software chamadas de objetos.
  ### Fundamentos
    - Abstração (processo pelo qual se isolam Características de um objeto considerando oque possuam em comum com outros grupos)
    - Reuso (Criar novas unidades de código a partir de ja existentes)
    - Encapsulamento (Capacidade de esconder complexidades)

    - **Classe**: estrutura que abstrai um conjunto de objetos com características similares. Define o comportamento dos objetos através de métodos e os estados possiveis através de atributos. Molde para entidades do mundo real.
    - **Atributo**: elemento de uma classe responsável por definir sua estrutura de dados. Representará as caracteristicas e fará parte dos objetos criados a partir da classe.
      - Atributos são criados dentro de CLASSES.
      - Variáveis são criadas dentro de MÉTODOS.
      - Utilizar nomes significativos
      - Contextualizados e abstraidos.
    - **Método**: porção de codigo disponibilizada pela classe e que é executado quando é feita uma requisição para ele. Serve para identificar quais serviços e ações a classe oferece. Definem comportamentos.
      - Construtor
      - Destrutor(auxilia na destruição dos objetos) "finalize()". Auxilia na liberação de recursos.
    - **Objeto**:representação de um conceito ou objeto do mundo real.
      - A classe é um molde para o Objeto.
      - Os objetos são instancias de classes.
      - A identidade é uma propriedade que permite identificar univocamente um objeto. Os objetos se distinguem por sua própria existência, independente de seu conteúdo. Dois objetos são distintos mesmo que todos os seus atributos sejam iguais, ou seja, existe um único identificador para cada objeto.
    - **Mensagem**: Retorno de uma chamada.

  ## HERANÇA
    - Relacionamento entre classes, onde uma classe (filha) é uma extensão da superclasse(pai). Devido a isso a subclasse filha consgue reaproveitar atributos e metodos da classe pai. Além disso ela pode ter seus próprios métodos.
    - Tipos:
      - Simples: a classe filha só tem uma classe "mãe/pai"
      - Multipla: uma classe pode herdar mais de uma classe pai. O Java não trabalha com esse tipo de implementação
    - Upcast e Downcast: 
      - subir na hierarquia de classe é UPCAST.
      - descer na hierarquia de classe é DOWNCAST. Sempre é preciso informar  para quem voce vai transformar. "B a = (B) new A();"
    - Polimorfismo: A mesma ação, se comportando de maneira diferente.
      - Polimorfismo X Sobrescrita: Polimorfismo é a capacidade de um objeto de assumir diversas formas, de modo que um objeto X, se polimórfico, poderia assumir por exemplo a forma do objeto Y. Uma das maneiras de implementar polimorfismo é através da herança. Sobrescrita é a capacidade de um objeto de oferecer uma implementação para um comportamento do objeto cuja forma ele assumiu. Assim, se X herda Y e sobrescreve um comportamento de Y, quando X assumir a forma de Y (for usado num lugar onde Y era esperado) e o tal comportamento for invocado, será executada a implementação de X e não de Y.
      - Polimorfismo (pode ser utilizado utilizando o "@Override").
      - Em Java, a palavra-chave **extends** é usada para indicar que a classe que está sendo definida é derivada da classe base usando herança. Então, basicamente, a palavra-chave extends é usada para estender a funcionalidade da classe pai para a subclasse. 
      - Em Java, heranças múltiplas não são permitidas devido à ambiguidade. Portanto, uma classe pode estender apenas uma classe para evitar ambiguidade.
```Java
class One { 
    public void methodOne() 
    { 
  
        // Some Functionality 
    } 
} 
  
class Two extends One { 
  
    public static void main(String args[]) 
    { 
        Two t = new Two(); 
  
        // Calls the method one 
        // of the above class 
        t.methodOne(); 
    } 
} 
```
  ## Associação: 
  - Possibilita um relacionamento entre classes/objetos, no qual estes podem pedir ajuda a outras classes/objetos e representar de forma completa o conceito ao qual se destinam. As classes interagem entre si para atingir o seu obejtivo.
    - Estrutural (Composição e Agregação)
      - Composição: Uma parte só pode existir com o todo, s eo Todo deixar de existir a parte também deixará de existir (por exemplo, o endereço de uma pessoa desaparece quando a entidade pessoa também desaparece).
      - Agregação:Uma parte pode existir sem o todo (por exemplo, um aluno pode deixar de existir, mas a disciplina continua existindo).
    - Comportamental(Dependencia);
      - Uma entidade depende de outra. (Um método de uma classe utiliza uma outra classe que, por sua vez, depende de uma chamada nessa classe pai para existir).
  ## Interface:
    - Define um contrato que deve ser seguido pela classe que a implementa. Quando a classe implementa uma iterface, ela se compromete a realizar todos os comportamentos que a interface oferece.
    - Uma classe concreta é uma subclasse de uma classe abstrata, que implementa todos os seus métodos abstratos.
      Métodos abstratos não podem ter corpo. A classe abstrata pode ter campos e métodos estáticos, como outras classes.
      Uma classe abstrata não pode ser declarada como final.
    - A palavra-chave **super** em java é uma variável de referência que é usada para fazer referência a objetos de classe pai. Se uma classe filha prcisar acessar uma variavel ou método da classe mais acima na hierarquia é possivel acessar esses trechos atraves do uso do "super".
    - Em Java, a palavra-chave **implements** é usada para implementar uma interface. Uma interface é um tipo especial de classe que implementa uma abstração completa e contém apenas métodos abstratos.
  
```java
  // Defining an interface 
  interface One { 
      public void methodOne(); 
  } 
    
  // Defining the second interface 
  interface Two { 
      public void methodTwo(); 
  } 
    
  // Implementing the two interfaces 
  class Three implements One, Two { 
      public void methodOne() 
      { 
    
          // Implementation of the method 
      } 
    
      public void methodTwo() 
      { 
    
          // Implementation of the method 
      } 
  } 
```

  ## PACOTES
    - Organização física ou lógica criada para separar classes com responsabilidades distintas. Espera-se que a aplicação fique mais organizada, com divisões de finalidades e representatividades.
    - Classes pertencentes a Packages diferetens devem ser importados na classe desejada atraves so uso do "import".(Por exemplo, import dio.curso.ClasseExemplo).

  ## VISIBILIDADE (Modificadores de acesso)
    - Determina até que ponto uma classe, atributo ou método pode ser usado. É fundamental para o uso efetivo da POO
    - Private(só visivel dentro da classe de onde se originou), Protected(visivel dentro da propria classe, sublicasses de relação direto ou que estão dentro do mesmo pacote), Public(visivel em qualquer lugar da aplicação)


