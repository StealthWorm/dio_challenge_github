## Spring Framework
  - Trouxe maior produtividade para projetos Java.
  - Dev não precisa se preocupar com configurações de baixo nivel.
  - O Core e o Beans fornecem as partes fundamentais para a estrutura do Spring (Core Container).
  - O Spring Boot é uma extensão do Spring que utiliza o Spring Framework para iniciar uma aplicação de forma simples e rápida, sem se preocupar com configurações complexas como ,por exemplo, o  Tomcat(servidor web).
    - é a soma do Spring Framework + Servidor embutido (Tomcat ou Jetty) - XML < bean> Configuration ou @Configuration

  - Ferramenta "Spring Initializr" para procurar dependencias mais comuns em projetos para criar o seu. API extensivel para gerar projetos baseados em JVM.

  - Auto-configurations
    - Configura automaticamente a aplicação Spring com base nas dependencias que adicionamos ao projeto.
    - @SpringBootApplication ( é acombinação de tres anotações):
      - @ComponentScan
      - EnableAutoConfiguration
      - Configuration

## Inversão de Controle(IoC)
  - É um princípio de design de programas de computadores onde a sequência (controle) de chamadas dos métodos é invertida em relação à programação tradicional, ou seja, ela não é determinada diretamente pelo programador.
  - Escrevemos a regra de negócio e as classes, porém quem vai montar a estrutura e que determina qual regra vai chegar primeiro que a outra é o Spring e não o desenvolvedor. O spring que determinará qual classe sera chamada primeiro.
  - É uma idea de desacoplar dependencias do objeto e fornecer controle para outra camada.

  - Application Context (Se baseia no BeanFactory, um mecanismo de config. de gerenciamento de objetos, porem adiciona mais funcionalidades)
    - Todo aplicativo Spring requer um Contexto, um local onde todos os componentes são registrados.  Quando usamos o Spring Framework e criamos algo, por exemplo, um conjunto de conexões, ele é registrado em nosso contexto ou quando criamos nossos próprios componentes(Beans) eles também serão registrados neste Contexto. Portanto, se em outra parte do aplicativo precisamos de um desses componentes, em vez de criá-lo novamente, podemos usa-lo dentro da instancia do Contexto(IoC).
    - Toda essa troca de responsabilidade funciona basicamente com as Annotations (o método mais facil de configurar).
    - Algumas anotações (@Component, @Controller, @Service, @Repository, @Autowired). Com o autowired setado encima de uma instancia de um componente, o Spring vai tentar gerenciar o componente automaticamente.
      ```
        @Autowired
        private UserService userService; //nesse exemplo userService é um componente em um package separado que foi declarado com a annotation "@Service".
      ```
    - Annotations evitam que vc precise instanciar manualmente as propriedades de uma classe/componente que voce precise usar. 
  
  - Expression Language
    - Define através de xml, código java ou anotações em tempo de execução, valores e comportamentos dos beans.
  
  ### Spring Beans
  - Bean: É qualquer objeto/classe gerenciado pelo Spring IoC. Ele é montado, instanciado e gerenciado por um container  do Spring através de Inversão de Controle e Injeção de Dependencia.
  - Diagamos que voce criou uma Bean com Annotation de **"@Repository"** para uma classe **"userRepository"**. 
    - Caso voce execute o build dessa forma o proprio Spring vai gerenciar as configs dessa classe como uma @Bean.
    - Caso essa anotação não esteja declarada, a classe/objeto deixará de ser reconhecido como Bean, então caso voce queira referenciar alguns de seus métodos ainda, sera preciso de uma chamada à classe atraves de outro arquivo de Configuração, por exemplo, em uma outra classe (BeanConfig) com a Annottation "@Configuration" no topo da classe e "@Bean" no corpo dessa classe instanciando a chamada da classe **"userRepository"**.
    -  Nessa nova classe de configuração , caso voce declare mais de uma "@Bean" com a mesma declaração ele vai dar erro no build, por não  saber qual das beans referenciar. Ele espera apenas uma Bean na configuração.
    - O "@Bean" serve para customizar o conteudo no Spring, ao inves de executar as configs padrão ao declarar uma Anottation na classe(**@Repository**).
    - Por exeplo, caso voce queira fazer um teste de contador antes de realizar cada chamada, dentro do Bean voce adiciona metodos que retornam valores no terminal.
  
  ### Stereotypes
  - São anotações do Spring, como as que declaramos até o momento: 
  - **@Repository:**
      - Representa uma anotação para qualquer classe que tenha interação com o Banco de Dados (INSERT, UPDATE, DELETE)
      - Ao fazer isso o Spring vai saber que essa classe trabalha com conexao no banco de dados, persistencia dos dados.
      - Com isso o Spring vai traduzir erros de SQL de uma maneira mais amigavel.
      - Só funciona encima de classes, não de métodos.
      - Geralmente Repository não sao declarados como calsses e sim como INTERFACES.
      - A interface extende "JpaRepository< Classe, IdTipo>" que lida com facilitadores de integração com o banco, como a parte de CRUD. Por exemplo o método "deleteById" vem desse extends.
        - Recebe como parametros a classe(entidade) que sera verificada pelo banco. Essa classe pode ser um "user" po exemplo, porem para ser reconhecido precisa possuir a Anotação "@Entity" no inicio da classe.
        - O segundo parametro é o tipo de "@Id" declarado nessa entidade. No caso do nosso "user" poderia ser um "Long".
      - Ao tentar subir o projeto, caso ele de algum erro nos metodos de crud por dizer que nao tem algum banco configurado, entçao tera de adicionar algum tipo de banco como dependencia no POM.xml. Um semplo seria o "com.h2database";
  - **@Service:**
      -  Notação de nivel de classe. Não pode ser declarada sobre métodos.
      -  Para classes que lidam com regra de negócio, acesso à serviços.
      
  - **@Controller / @RestController:** 
      - Nada mais é que uma classe contendo anotações especificas para a disponibilização de recursos HTTP baseados em serviços e regras de negócio.
      - Para classes que representam controladores no SpringIOC, ou seja, aquela que vai controlar as chamadas de telas.
      - Apresentação de Dados.
      - Pegas os dados tratados pelos services e mostra em tela.
      - @RestController, ao inves de trazer uma tela inteiro para o frontend, ele vai pegar alguns dados e voltar para o front como um json. Faz as mesmas coisas que o @Controller, mas serve pra retornar dados em JSON.
      - Mostra um json em tela ao acessar o caminho.
  - **@Configuration:** 
      - classe para configurações do projeto. Por exmplo o @Beans, controle de usuários, etc.
  - **@Component:**
      - Anotação para classes genéricas, que não se encaixam como Configuração, Controle ou Serviço.
      - Todas os outros stereotypes vem dessa.
  
  ### Bean Scopes
  - Utilizada para marcar o tempo de vida  de um objeto gerenciado pelo conteiner.
  - Singleton: 
    - uma unica instancia pra qualquer chamada ou objeto do projeto. 
    - Qualquer Bean onde não tenha sido definido o escopo sera tratada como essa por padrão.
    - Não importa quantas instancias voce faça de uma classe Singleton dentro de uma classe, sempre vai pegar a primeira bean.
  - Prototype:
    - o oposto do Singleton.
    - Cada nova instanciação do objeto Bean cria um objeto novo. Sempre que for chamado intancia um objeto novo.
  - Request:
    - cria uma instancia de um Bean para cada requisição HTTP.
    - seu ciclo de vida acaba ao final de cada requisição.
    - Assim que termina a requisição e retorna os dados para o usuário ele destroi a Bean instanciada. Retira da memoria que estava alocando.
  - Session:
    - mistura do Singleton com o RequestScope.
    - Cria uma requisição unica, porém para cada sessão. 
    - Para cada usuário novo, ou reentrada, sera criada uma sessão nova.
    - Caso a sessão (janela) do usuario permaneça aberta ele entende que a sessão ainda existe, então nao apaga a instancia. Caso voce feche a janela e abra de novo ai sim ele cria uma nova sessão.
  - Application: 
    - Uma instancia por aplicação. Se tiverem mais sistemas conectados, será uma instancia para a sessão de todas as aplicações juntas.
    - A Bean só é fechada em caso de fechar a sessão das aplicações e reinicia-la.
  - WebSocket:
    - Parece com escopo de Sessão.
    - Só para WebSocket.
    - O WebSocket fica ligado a um pagina e ao backend.
    - Quando voce da um refresh na pagina, cancela o WebSocket, dai ele remove da memoria e gera um novo Bean.

## Injeção de Dependências
  - Uma forma de aplicar **Inversão de Controle** em uma classe que utiliza funcionalidades de outras classes.
  - Se uma classe depende de outra (pelas metodos "@Autowired" na instanciação da mesma), o Spring ja entende que precisa instanciar os metodos dessa classe sem que o desenvolvedor tenha que se preocupar em configurar.
  - Ja faz parte do fluxo natural do Spring.

  ### Proxies e Setter
  É o modo como o Spring procura e injeta nossas dependencias. É um ponto de Injeção para o Spring entender o que ele deve buscar ou não.
  Ja utilizamos eles através da "@Autowired".
  O proxy / setter vai procurar quem é a classe/objeto elegivel para atribuir ao ponto de injeção para poder executar a requisição.
  - Propriedades
    ```java
      // declara um ponto de injeção de propriedade
      @Autowired
      private UserService userService;
    ```
  - Construtores
    - úteis em testes de software. Torna mais facil.
    ```java
      // passa no construtor o atributo que voce quer injetar
      @Autowired
      public UserService(UserRepository userRepository) {
          this.userRepository = userRepository;
      }
    ```
  - Métodos
    - Onde criamos um método Setter e podemos declarar mais regras de negocios dentro da chamada, alterando o comportamento dela.
    ```java
      @Autowired
      public void setUserRepository(UserRepository userRepository) {
        // executa outra regra
        /**
        * sfbalsdfh
        */
        this.userRepository = userRepository;
      }
    ```
  ### Suporte CDI
  CDI - Context Dependency Injection
  É a especificação do Java que define a injeção de dependencia e inversão de controle para aplicações JavaEE.
  Possui pequenas diferenças na sintaxe.
  - Na declaração da classe, ao inves de usar o "@Bean" utiliza o "@Named"
  - Na classe que vai instanciar a Bean, ao inves de utilizar o "@Autowired", utilizamos o "@Inject"

  ```java
    @Named
    public class CdiConfig {

      @Inject
      private CdiTeste cdiTeste;
      
      @PostConstruct
      public void init() {
        cdiTeste.executaTeste();
      }
    }

  ```
  ### Bibliotecas e Dependencias
  - **Swagger**
    - Dependencia bastante utilizada comentar e documentar APIs REST.
    - Por boas praticas criamos pacotes onde vao ficar os arquivos de config da documentação;
    - Contem diversas ferramentas  para desenvolver APIs com a especificação OpenAPI Specification (OAS). Com o OAS voce pode descrever recursos, consumir e produzir  serviços, URIs, modelos de dados, métodos HTTP e códigos de resposta.
    - Precisa ser adicionada nas dependencias do projeto.
    - A classe recebe Annotation "EnableSwagger2"
    ```java
    @Configuration
    @EnableSwagger2
    public class SwaggerConfig() {

      public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.digitalinnovationone.personapi.controller")).paths(PathSelectors).any().build().ApiInfo(buildApiInfo());
      }

      private ApiInfo buildApiInfo(){
        return new ApiInfoBuilder()
                                  .title("API Person")
                                  .description("REST API para gerenciamento de pessoas")
                                  .version("1.0.0")
                                  .contact(new Contact("Renan Marques", "github/re04nan", null))
                                  .build();
      }
    }
    ```
    - Para que o Swagger não precise escanear toda a aplicação, definimos caminho do pacote de Controllers no ".apis()"

  **Observações:**
    - Caso ele de erro de compilação apos criar a classe de Configuração tentar os seguintes passos:
      - Adicionar "spring.mvc.pathmatch.matching-strategy=ant_path_matcher" no application.properties na pasta de resources
      - adicionar a dependencia a seguir junto das do swagger no pom.xml
        ```java
          <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
            <version>3.0.0</version>
          </dependency>
        ```
      - ao inves de acessar o caminho padrao no navegador "http://localhost:8080/swagger-ui.html", tente trocar por "http://localhost:8080/swagger-ui/index.html"

  - **Feign**
    - Cliente de Serviço Web declarativo (cliente HTTP) criado pela Netflix.
    - Com ele é possível criar clientes API HTTP no java de forma mais simples para chamar/consumir os serviços REST, utilizando anotações.
    - Para usar o Feign, precisamos adicionar a dependência spring-cloud-starter-openfeign no arquivo pom.xml.
    ```java
    @SpringBootApplication
    @EnableFeignClients //habilita o Feign na aplicação
    public class Projetoonefeign2Application {

      public static void main(String[] args) {
        SpringApplication.run(Projetoonefeign2Application.class, args);
      }

    }
    ```

    - Na classe qque estamos consumindo:
    ```java
    // Diz qual a url da nossa api
    @FeignClient(name="agenda", url="http://localhost:8080/contato")
    public interface ConsumindoApi {
      
      @RequestMapping(method = RequestMethod.GET, value="/")
      Contato retornaContato();

    }
    ```
  ## Spring Boot
  Enquanto o Spring Framework é baseado no padrão de Injeção de Dependencia, o Springboot foca em configuração automática.
  Foca na produtividade.
  Configurações automáticas para evitar trabalho verboso no inicio dos projetos.
  
  - Starters mais utilizados
    - data-jpa: Integração com banco de dados via JPA - Hibernate.
    - data-mongodb: Integração com banco de dados MongoDB.
    - web: Inclusão do container Tomcat para aplicações REST.
    - web-services: Webservices baseados na arquitetura SOAP.

  A ideia do Spring Boot é que componentes nao precisem mais ser instanciados atraves do no "new Component()"

  **Beans x Components**
  - *@Bean*: Quando não tenho acesso ao código fonte. Bibliotecas externas que voce quer declarar como um componente reutilizável.
    - classes externas nao possuem o "@Component" pra declarar ela como Bean e poder reutilizar, por isso é preciso criar uma estrutura pra declarar ele como um @Bean. Por exemplo,  para utilizar a classe "Gson", do Google, poderia ser criada uma classe com a anotação "@Configuration" onde seria declarado um "@Bean" que retorna um novo Gson. Dessa forma a extrutura que antes era externa agora pode ser reutilizada em qualquer parte do código.
    - Caso a referecia externa precise ser utilizada varias vezes não é uma boa pratica declarar o Beans no main pra cada chamada, o ideal é criar uma classe "Beans" referenciando todos os beans externos que precisamos utilizar.
  - *@Component*: Quando é uma classe que possui a possibilidade ou necessidade de ser provida por Injeção de Dependencia.

  **@Value**
    - ele serve para que você possa capturar o valor de alguma propriedade definida lá naquele arquivo application.properties no diretório resources.
    - Em um contexto de API, por exemplo, onde preciso me conectar com banco utilizando credenciais, poderiamos colocar os dados de acesso no diretorio resources como constantes e utilizar esses valores nos locais adequados. Como se fosse um ".env".
    - Remove a necessidade de declarar valores direto na classe.
    - **@Value("${name:NoReply-DIO}")**. Depois dos dois pontos *":"* ele define um valor padrão, caso nao encontre uma propriedade definida no resources.
  
  **@ConfigurationProperties (prefix)**
    - Uma maneira de incluir uma configuração externalizada e de fácil acesso a propriedades definidas em arquivos de propriedades. 
    - Definir de forma centralizada todas as informações referentes a um contexto 
    - Imagine o caso de uma API com varias credenciais. Ao invés de declarar as variaveis de acesso localmente na classe, voce cria configurações para cada contexto em que voce pretende testar, não deixando fixo os dados no código e tornando mais facil criar instancias da aplicação tendo valores pertinentes ao contexto.
    - "Eu tenho um Bean de Configuração que todos os seus valores vão vir através do ApplicationProperties"
    - Deve-se centralizar as declarações de "@Value", por exemplo, se o diretório de resources possui 3 atributos
      ```java
      remetente.nome=NoReply-DIO 
      remetente.email=noreply@dio.com.br
      remetente.telefones=1145651725,1187651343
      ```
     e queremos setar valores em varias classes utilizando essas propriedades, ao invés de declarar chamadas utilizando "remetente.", podemos criar um @ConfigurationProperties e definir o contexto "remetente" na classe que vai utilizar esses valores
      ```java
        @Configuration
        @ConfigurationProperties(prefix = "remetente")
        public class Rementente {}
      ```
      A partir dessas anotações ele diz "eu sou um Bean de Configuração" e todos os meus atributos estou pertinentes ao prefixo "remetente". Dessa forma a chamada dos valores é dinamica.

  ### ORM e JPA
      ORM: Mapeamento de Opjeto Relacional, um recurso para aproximar o paradigma da POO ao contexto de banco de dados relacional.
      É realizado através do mapeamento de objeto para uma tabela por uma biblioteca ou framework.

      JPA: É uma especificação baseada em interfaces, que atraves de um framework realiza operações de persistencia de objetos em Java.

      Em um projeto Spring Boot, toda a parte de configuração fica centralizada no arquivo **application.properties**, inclusive configurações de banco.

      Repository Pattern
        é um padrão de projeto similiar oa DAO (Data Object Access) no sentido de seu objetivo é abstrair o acesso  a dados de forma genérica a partir do seu modelo.
        O projeto Spring Data JPA facilita a implementação do padrão Repository através do AOP (Aspect Oriented Programming)
        Utilizando-se de apenas uma interface, o Spring irá "gerar" dinamicamente a implementação dos métodos de acesso a dados.

  ### Spring Boot REST API
      Controller: recurso que disponibiliza as funcionalidades de negócio da aplicação através do protocolo HTTP. É como uma camada que diz "o serviço funciona de forma local e quero disponibiliza-lo para o mundo através de um web API"
      
      ```java
      @RestController
      public class WelcomeController {

          @GetMapping //dizendo que o método welcome é um recurso HTTP do tipo GET utilizando GetMapping
          public String welcome(){
              return "Welcome to my Spring Boot Web API";
          }
      }
      ```

      Annotations
      @Controller
        Essa anotação é usada para fazer uma classe como um controlador da web, que pode lidar com solicitações de clientes e enviar uma resposta de volta ao cliente. Esta é uma anotação de nível de classe, que é colocada no topo de sua classe de controlador. Semelhante a @Service e @Repository , também é uma anotação de estereótipo.
      @RequestMapping (*"@RequestMapping("/")"*)
        A classe Controller contém vários métodos de manipulador para lidar com diferentes solicitações HTTP, mas como o Spring mapeia uma solicitação específica para um método de manipulador específico? Bem, isso é feito com a ajuda da  anotação @RequestMapping . É uma anotação de nível de método que é especificada sobre um método de manipulador.
        Ele fornece o mapeamento entre o caminho da solicitação e o método do manipulador. Ele também suporta algumas opções avançadas que podem ser usadas para especificar métodos de manipulador separados para diferentes tipos de solicitações no mesmo URI, como você pode especificar um método para manipular solicitações GET e outro para manipular solicitações POST no mesmo URI.
        O **@GetMapping** possui um principio parecido ,ja que trabalha com requisições do tipo GET.

      @PathVariable
        Para extrair informações d euma URI

      @RequestBody
        Requisita o corpo da requisição HTTP em um formato JSON
  ### Spring Boot Tratamento de Exceções
    @ExceptionHandler: funciona no nivel do "@Controller", onde cada método trata uma exceção de forma declarativa. Nçao é muito produtivo em contextos maiores.

    ResponseStatusExceptionResolver: sua principal responsabilidade é usar a anotação "@ResponseStatus" disponivel em exceções personalizadas e mapear essas exceções para códigos de status HTTP. Se tiver uma exceção especifica, a aplicação vai receber pelo status que foi apresentado o redirecionamento para uma exceção.

    RestControllerAdvice: nos permite consolidar multiplos @ExceptionHandler em um único componente global de tratamento de erros. Nos da controle total  sobre o corpo da resposta, bem como o código de status.

  ### Spring Boot Test
      - Bastante utilizado no desenvolvimento de aplicações java para testar comportamento do código e regras de negócio.
      - **spring-boot-start-test**
      - Diz ao Spring Boot para procurar uma classe de configuração principal e usá-lá para iniciar um contexto de aplicativo Spring.
      - A anotação "@SpringBootTest" é utilizada em uma classe de teste e diz ao Spring Boot para procurar uma classe de configuração principal, por exemplo, o @SpringBootApplication, e usá-la para iniciar um contexto de aplicativo Spring.
      - É bem semelhante aos testes unitarios padrão do JUnit em Java, com a sintaxe @Test e algumas validações nos metodos como o "assertEquals".

      É um tipo de teste que envolve comunicação entre as unidades, simulando requisições.
      - Na classe que vai ter um contexto para ser analizada é preciso da annotation "@SpringBootTest"
      - Na pasta de testes, é preciso criar um novo arquivo de testes com algumas anotações imbutidas no SpringBootTest:
        - @WebMvcTest                        -> utilizada para testes de requisições
        - @ExtendWith(SpringExtension.class) -> pra poder utilizar alguns contextos da biblioteca de testes
  






