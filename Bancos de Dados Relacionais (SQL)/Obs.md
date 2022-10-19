DADOS -> INFORMAÇÕES

Dados: valores brutos, observações, registros soltos sem qualquer tratamento.
Informação: Estrturação dos dados , organização. Conjunto de dados relacionados e que geram valor. Gera sentido nos dados.

Modelo Relacional
  - Mais comum. Cassifica  e organiza os dados em linhas e colunas em uma ou mais tabelas (tuplas). As linhas ou tuplas, são dados organizados, os valores da tabela enquanto as colunas são os atributos.

Tabelas
  - Conjuntos de dados dispostos em colunas e linhas referentes a um objetivo comum.
  - Pode definir Coisas tangiveis(carro, produto), Funções(perfil de usuário, status da compra) ou Eventos de Ocorrencias(produtos de um pedido, histórico de dados).
  - Primary key (conjunto de um ou mais campos que não se repetem). São os identificadores dos registros
  - Foreign Key (valor de referencia a uma PK de outra tabela para criação de relacionamentos)

POSTGRESQL
  - SGBD (Sistema Gerenciador de Banco de Dados) Objeto Relacional.
  - Opensource.
  - Arquitetura Multiprocessos.
  - Modelo Clienete/Servidor.
  - linguagem Procedural (SQL).
  - Suporte a View, Procedures, Triggers.

  - postgresql.conf: arquivo onde estão difinidas todas as configurações do servidor PostgreSQL.
    - (C:\Program Files\PostgreSQL\15\share) no windows
    - Alguns parametros só podem ser alterados com a reinicialização do banco
    - A view "pg_settings", acessada dentro do banco de dados, guarda todas as configurações atuais
    - Show [parametro]
    - Encontra-se dentro do diretorio "PGDATA" definido no momento da inicialização do cluster de banco de dados.

 - Configs. de conexão 
   - LISTEN_ADRESSES: Endereço(s) TCP/IP das interfaces que o servidor vai escutar/liberar;
   - PORT: A porta TCP que o servidor vai ouvir. (O padrão é 5432);
   - MAX_CONNECTIONS: Número máximode conexões simultaneas no servidor;
   - SUPERUSER_RESERVED_CONNECTIONS: Número de conexões (slots) reservadas para conexões ao banco de super usuários.

 - pg_hba.conf
  - Arquivo responsável pelo controle de autenticação dos usuários no servidor.

 - pd_ident.conf
   - Arquivo responsável por mapear os usuários do SO com usuários do banco de dados. Localizado no diretório PGDATA da instalação. A opção ident deve ser utilizada no arquivo pg_hba.conf

 - Cluster: Coleção de dados que compartilham as mesmas configurações (arquivos de configuração), e do Sistema Operacional(porta, listen_adresses, etc).
 - Banco de Dados: Conjunto de schemas com seus objetos/relações
 - Schema: conjunto de objetos/relações (tabelas, funções, views, etc).

  - usar o SQL Shell para conseguir acessar o cluster;
  
  - ROLES
    - IN ROLE
    - ROLE
    - GRANT
    - REVOKE
    - INHERIT
    - ALTER ROLE
    - DROP ROLE
    - "\du" no terminal lista as roles criadas 

## DATABASE
  - É o banco de dados em si.
  ### Schemas
  - é um grupo de objetos, como tables, views, funções, entre outras.
  ### Objetos
  - São tabelas, views, funções, types, sequences, etc. Pertencentes aos schemas
  - **DML**: Data Manipulation Language. INSERT,UPDATE, DELETE, SELECT.
  - **DDL**: Data Definition Language. CREATE, ALTER, DROP.
  - evite o "SELECT *"
  - **Idempotencia**: propriedade que algumas ações/operações possuem que as permitem serem executadas diversas vezes sem alterar o resultado após a aplicação inicial.
  - Uma boa prática é usar o "IF NOT EXISTS" para criar tabelas, evitando erros caso o trecho seja executado novamente.

  ## Melhores práticas DDL
  - defina campos em uma tabela que REALMENTE serão utilizados e que sirvam de atributo direto a um objetivo em comum.
  - Cuidado com regras (constraints)
  - Cuidado com excesso de FKs
  - Cuidado com o tamanho indevido das colunas

  ## Melhores práticas DML
  - Selects exclusivos e objetivos, **evitar uso do asterisco (*)**. Quanto melhor a condição, mais rápido o acesso aos dados.
  - SELECT LIKE
  - Cuidado com Subselects
  - Condições (WHERE, AND, OR)
    - Comparadores: "=", ">=/ >", "<=/ <", "<> / !=", "LIKE", "ILIKE", "IN" 
  - CRUD
    - INSERT(*campos*) VALUES(*valores*)
    - INSERT(*campos*) SELECT(*valores*)
    - INSERT INTO *TABELA*(*campos*) VALUES(*valores*) ON CONFLICT (*dados_para_validar_conflito*) DO NOTHING;
    - UPDATE(*tabela*) SET *campo* = *novo_valor* WHERE (*condicao*)
    - DELETE FROM(*tabela*) SET *campo* = *novo_valor* WHERE (*condicao*)
    - TRUNCATE: "Esvazia" a tabela

  ## Funções Agregadas
  -  **precisam de agrupamentos "GROUP BY" ou "ORDER BY" para os campos que não estao sendo agrupados atraves das funções agregadoras, ja que nesta  esta agrupando os campos em um COUNT, SUM, MAX, etc**
  - AVG:média
  - COUNT(HAVING)
  - MAX
  - MIN
  - SUM

   ## JOINS
   - JOIN/ INNER JOIN: campos da tabela A deve pertencer a uma mesma relação na tabela B;
   - LEFT JOIN: a tabela relacionada a esquerda vai vir por completo, enquanto na tabela a direita vai trazer somente os registros que tiverem relacionamento. Os registros da tabela a esquerda que não possuirem relacionamento ele traz nulo.
   - RIGHT JOIN: a tabela relacionada a direita vai vir por completo, enquanto na tabela a esquerda vai trazer somente os registros que tiverem relacionamento. Os registros da tabela a direita que não possuirem relacionamento ele traz nulo.
   - FULL JOIN / FULL OUTER JOIN: traz todas as relações possiveis entre as tabelas A e B, incluindo as que não se relacionam.
   - CROSS JOIN: todos os dados de uma tabela serão cruzados com todos os dados da tabela referenciada em CROSS JOIN, criando uma matriz.Todos  os dados de uma tabela A, criam uma relação com todos os dados da Tabela B.

  ## CTE - Common Table Expressions
  - Forma auxiliar de organizar "statements", ou seja, blocos de códigos para consultas muito grandes, gerando tabelas temporárias e criadno relacionamentos entre elas.
  - WITH STATEMENTS
  ```
    WITH [nome1] AS (
      SELECT(campos)
      FROM tabela_A
      [WHERE]
    ), [nome2] AS (
      SELECT(campos)
      FROM tabela_B 
      [WHERE]
    )
    SELECT [nome1].(campos), [nome2].(campos)
    FROM [nome1]
    JOIN [nome2]...
  ```
  ## VIEWS
  - Visões, são "camadas" para as tabelas, são "alias" para uma ou mais queries.
  - Fornecem segurança, uma vez que o acesso aos dados passa a ser utilizando a view e não a tabela em si.
  - INSERT, UPDATE e DELETE só funcionam para referencias a uma unica tabela, se houverem Joins ele não funciona.
  - TEMPORARY: indica que a view só é ativa na sessão visivel, se voce fechar a janela ele apaga.
  - RECURSIVE: o comando no interior da view vai chamar ela mesma
    - Obrigatório a existencia dos campos da VIEW
    - UNION ALL
  - WITH LOCAL CHECK OPTION: significa que eu quero validar opções da view presente. Ao tentar fazer u insert na View sem corresnponder as opções que ela pede (por exemplo tentar inserir um registro menor que 100 em uma view eu filtra esse mesmo campo para valores maiores que 100), ele retornará erro.
  - WITH CASCADED CHECK OPTION: valida as opções da view atual inclusive das views a qual ela faz referencia .

  ## TRANSACTIONS
  - Conceito fundamental de todos os bancos de dados.
  - Conceito de múltiplas etapas/códigos reunidos em apenas uma transação, onde o resultado precisa ser TUDO ou NADA.
  - Forma segura de executar funções.

  ## FUNÇÕES
  - Conjuntos de códigos executados **dentro de uma transação** com a finalidade de facilitar a programação e obter o reaproveitamento de códigos.
  - Existem 4 tipos:
    - query language functions(funções escritas em SQL);
    - procedural language functions (funções escritas em, por exemplo, PL/pgSQL ou PL/py)
    - internal functions
    - C-language functions

  ### USER DEFINED FUNCTIONS
  - RETRUNS: Indica o tipo de retornos da função que esta sendo criada
  - SECURITY:
    - INVOKER (padrão): permite que a função seja executada com as permissões do usuário que esta executando a função. Se o usuário não ppossui permissão para realizar alguma operação (INSERT, por exemplo), ao tentar executar esse comando vai reornar erro.
    - DEFINER: o usuário que executa a função executa a mesma com as permissões  do usuário que criou a função. Tomar cuidado pois se a função foi criado por um SUPER USER, quem chamou a mesma poderá executa-la com as mesmas permissões.
  - COMPORTAMENTO:
    - IMMUTABLE: Não permitem comandos para alterar o banco. Permite apenas comandos que possam retornar o mesmo valor  quando voce utilzia os mesmos argumentos. Garante que o retorno seja imutável.
    - STABLE: Não permitem comandos para alterar o banco. Permite apenas comandos que possam retornar o mesmo valor  quando voce utilzia os mesmos argumentos. Permite SELECTS.
    - VOLATILLE: Comportamento padrão. Aceita todos os cenários.
  - RECURSOS
    - Permitem controle do uso de recursos de uma função
    - COST: custo em unidades de CPU.
    - ROWS: num. estimado de linhas analisadas pelo planner
  - **FUNÇÕES SQL NÃO PERMITEM TRANSAÇÕES**

