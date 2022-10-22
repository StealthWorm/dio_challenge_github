## Apache Maven
  Ferramenta para gerenciar builds. O Maven resolve problemas de empacotamento da aplicação em formatos especificos, gerenciamento de testes e compilaçao. 

  Enderaça atraves do *POM*

  Fornece informações de qualidade.

  <strong>geração automatica de um projeto com base em um template, existem varios tipos</strong>
  <p>na linha de comando digite:</p>

  > mvn archetype:generate -DgroupId=one.digitalinnovation -DartifactId=quick-start-maven -Darchtype=maven-archetype-quickstart -DinteractiveMode=false

  ### COMANDOS
  - Compile (mvn compile): pacotes são compilados e inseridos na pasta *"target"* na raiz do projeto
  - Test (mvn test): maven encontra todas as classes de teste e executa os possiveis testes que podem existir.
  - Package (cria o jar da aplicação)
  - Clean (limpar diretório de trabalho, arquivos da pasta target)

  ### maven archetype
  - arquétipos para criar projetos com configurações especificas para o que precisamos.
  - o comando gerado acima "mvn arqchetype...." é um exemplo
  - MVN Repository, basta procurar por archetype.

  ### POM
  - Project Object Model 
  - Unidade fundamental de trabalho
  - Formato XML
  - Detalha o Projeto e como contruir ele.
  - Configurações de ambiente.
  - Os repositórios padrão são configurados pelo Super POM para utilizar o Maven Central.
  - podemos inferir acesso a repositorios remotos no POM atraves da tag "mirror".
  - 

  **<p>O POM.xml básico só precisa de informações das tags < modelVersion >, < groupId >, < artifactId >, < version > </p>**
  <p>As demais configs ele extende do SUPER POM</p>

  ### Gerenciamento de dependencias
  - Vc pode importar uma dependencia externa dentro do POM (tag dependecy).
  - Caso queira publicar seu projeto/componente para que outros utilizem como uma dependencia, voce pode utilizar o "mvn install" no terminal do projeto, que assim ele publica localmente o seu componente/projeto, tornado-o uma dependencia passivel de uso.
  - Dependencias Diretas: aquela que voce declara direto no POM.xml
  - Dependencias Transitivas: as dependencias do componente que voce declarou e que tambem estao sendo usadas por ele passam a ser dependencias da classe que chamou esse novo componente, como se fosse obrigatoria para instancia-lo. São herdadas indiretamente quando passamos a utilziar o novo componente.

  - Para lidar com o problema de multiplas dependencias não utilizadas por um projeto que importou um componente que , por sua vez, utiliza essas dependecias internamente em seu funcionamento, o maven trabalha com escopos. Existem 6 tipos.
    - Runtime
    - Test
    - Compile
  
    - **Escopo Compile**: é o escopo Default: disponivel em todos os classpaths, e que é transitivo.
    - **Escopo Provided**:  indica que a dependencia sera fornecida em tempo de execução por uma implementação na JDK ou via container(a dependencia com esse escopo é adicionada no classpath usado para "compile" e "test", mas não em runtime). Não é transitiva.
    - **Escopo Runtime**: Indica que a dependencia é necessária para execução e não para compilação. (maven inclui no classpath dos escopos de runtime e test). É necessária somente no momento de executar o software.
    - **Escopo Test**: Disponivel somente para compilação e execução de testes. Não é transitivo.
    - **Escopo System**: similar ao Provided, porem precisa prover o JAR explicitamente. é adicionado no classpath usado para compilação e teste mas não em runtime. Não é transitiva. Funciona utilizando uma localização no sistema.  
      ```
      <scope>system</scope>
      <systemPath>${Project.basedir}/libs/custom-dependency-1.3.2.jar</systemPath>
      ```
    - **Escopo Import**: disponivel apenas como uma dependencia do tipo pom e com tag *< dependencyManagement >*. Indica um processo  de reutilizar dependencias de um projeto.

  <strong><u>Dicas sobre Escopos, Dependencias Opcionais e Exclusions</u></strong>
  - para ver o classpath, ou seja, como o Maven esta contruindo cada escopo do projeto:
  - Para cada comando ele apresenta o classpath construido para o escopo definido após o sinal de igual "="
    ``` mvn dependency:build-classpath -DincludeScope=compile```
    ``` mvn dependency:build-classpath -DincludeScope=teste```
    ``` mvn dependency:build-classpath -DincludeScope=runtime```

  - Dependencias Opcionais:
    - Utilizado quando a dependencia não é necessaria para os projetos que irão reutilizar seu componente. (tag < optional >true< /optional >). 
    - Isso remove a transitividade das dependencias que voce não quer que apareçam indevidamente no seu projeto.
  - Exclusions:
    - Utilizado quando o componente que voce usa compartilha uma biblioteca que voce ja tem ou não quer ter disponivel.
    - tag "exclusions" para criar o grupo e, pra cada exclusao, voce cria uma tag "exclusion"
    - Uteis quando nao se tem um controle bem definido das dependencias que serão importadas e , por algum motivo, a equipe nao pode solicitar uma mudança nesse componente. Então para evitar receber desse componente bibliotecas não utilizadas voce adiciona nos exclusions. 
  
  ### Maven Lifecycle
  - 3 ciclos de vidas
    1- Default Lifecycle:
      - principal ciclo
      - responsável pelo deploy local (mvn install, mvn compile, etc)
      - composto por 23 fases (validate, compile, test, deploy, package, etc)
    2- Clean lifecycle:
      - Ciclo intermediario
      - Responsavel plea limpeza do projeto
      - composto de 3 fases (pre-clean, clean, post-clean) 
      - Introduzido para que o projeto fosse preparado para uma fase de publicação
    3- Site lifecycle:
      - Ciclo final
      - Responsavel pela criação do site de documentação do projeto 
      - Composto de 4 fases (pre-site, site, post-site, site-deploy)
      - Existem plugins no Maven para geração de documentação
  
  ### Projetos multi-modulos
  - Quando voce cria um projeto e define outros projetos/dependencias dentro dele, o projeto no topo da hierarquia vai possuir uma tag "modules" no seu POM.xml agregando os subModulos adicionados.

  ### Plugins
  - A maioria das funcionalidades provem de plugins
  - Estilo arqitetural para extensibilidade(criar seu próprio plugin)
  - São disponibilizados como JARs
  - Uso:
    ```mvn [plugin-name]:[goal-name] ``` 
    ```mvn dependency:help ```
    - mvn dependency:analyze -> verifica as dependencias que NÃO estão sendo usadas
  - Configura no mesmo estilo de uma dependencia (GroupId, ArtifactId)

