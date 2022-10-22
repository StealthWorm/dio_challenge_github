## HTTP (Hypertext Transfer Protocol, camada de aplicação):
  - Protocolo de Comunicação. (Client-server)
  - Determina como as partes vao se comunicar. 
  - Ponte entre Cliente e Servidor. 
  - Cliente (Mensagens REQUESTS, Objetos web)
  - Servidor (Mensagens RESPONSE, protocolo TCP (camada de Transporte))
    - • Browser -> implementa o cliente HTTP
    - • Servidor -> host objetos web
  - Stateless (não armazena estado do cliente, as requisições são completas e executadas repetidas vezes)
    - É necessário fornecer à requisição todas as informações necessárias para completa-la.

  - HTTP 1.1 funciona como uma comunicação de 3 vias em sua Transmissão
    - SYN
    - SYN ACK
    - ACK
  - Keep Alive: manter os dados persistentes sem perder as informações
  - Conexão persistente(mantem a conexão ativa ate receber um comando para encerrar)
    - HOL (Head of Line Blocking): não encerro até receber minha resposta
    - Overhead (toda vez utiliza o cabeçalho)
  - não-persistente(executa a requisição e ja encerra)

  - HTTP Entity Body
    - Mapeamento **XML** ou **JSON**. 
      - XML é utilizado par serialização dos dados. Um processo de transformação dos dados para que haja comunicação entre as partes.
        - Metadados.
        - Utiliza Tags
      - JSON é baseado no JavaScript
        - Lightweight (sintaze mais leve e legivel)
        - simples
        - independe de linguagem.
        - Utiliza chave/valor

  #### HTTP REQUEST
    - Métodos seguros (não alteram o estado do servidor), IDEMPOTENTES, Operações de leitura:
      - GET
      - HEAD
      - OPTION
  #### HTTP RESPONSE
      - Status Code
        - 100 - 199 (information response)
        - 200 - 299 (successful response)
        - 300 - 399 (redirection response)
        - 400 - 499 (client error response)
        - 500 - 599 (server error response)

  **Cookie e Cache**
  - Cookie
    - Cookie é para quando há a necessidade de identificar o cliente
    - Track de informações do cliente, para persistir os dados no dispositivo do cliente.
    - Cookies de Sessão
      - A partir do momento que a sessão se encerra ele apaga os dados.
    - Cookies Persistentes
      - Persiste as informações no dispositivo.
      - Informações de login
    - LGPD: Dados pessois de clientes, por isso os sites pedem consentimento para Cookies.
  - Cache
    - também chamado de proxy server
    - é um intermediario e é implementado tanto no lado do cliente quanto no lado do servidor. 
    - O armazenamento em cache de multimídia e outros arquivos pode resultar em **menos atraso geral** ao navegar na Web.  Afinal, se os dados estão disponiveis em cache e não sofreram alterações não há a necessidades de executar outra requisição para atualiza-los.

  ### WebDAV 
  é um acrônimo de Web-based Distributed Authoring and Versioning, ou Criação e Distribuição de Conteúdo pela Web. É uma extensão do protocolo HTTP para transferência de arquivos; suporta bloqueio de recursos. Quando uma pessoa está editando um arquivo, ele fica bloqueado, impedindo que outras pessoas façam alterações ao mesmo tempo.
  
  #### HTTP 2.0
  - HTTP 1.1 possui o problema HOL (Head of Line Blocking) onde vc não pode fazer outra requisição, pois o estado esta bloqueado, em uma requisição até receber a resposta da mesma.
  - No 2.0 existe a **multiplexação** de canais, onde cada requisição é enviada em streamings distintos, não bloqueando uma requisição enquanto outra não obtem resposta.
  - A ordem é definida por pesos, onde cada requisição possui uma prioridade especifica.
  - há reutilização de header ao inves de reenvia-lo em cada requisição
  - Método PUSH
    - O Server Push resolve o problema do inline direto no protocolo de forma simples e elegante. A ideia é que, quando o usuário requisitar o HTML por exemplo, podemos enviar a resposta do CSS junto mesmo antes de ele requisitar.
  - unica conexão persistente
  - HTTPS por padrão - TLS
  
  - CONTRAS:
    - Se o PUSH for configurado incorretamente pode gerar problemas
    - Misturar HTTP 1.1 com 2.0 pode causar lentidão
  
  #### SERVIDORES HTTP
  - Apache
  - XAMPP
  - NGINX
## HTTPS
  - HTTP + SSL
  - Criptografia por chave
    - Assimetrica
      - Chave privada: Assinatura - criptografia
      - Chave publica: verificação de autenticidade
    - Simétrica
      - Chave Única. Mesma chave para criptografar e descriptografar
      - Ambas as parte precisam ter conhecimento previo da chave
      - Cifra de fluxo: Mapeamento bit a bit pseudo-aleatórios.
      - Cifra de Bloco: SSL, PGP, IPsec. Mapeamento em Bloco de Bits (64bits).
        - Tabela de permutações de combinações possiveis para a cifra.
  - Certificado Digital
    - Certificaçao de chave publica.
    - Entidade certificadora. (Padroes  de autoridades certificadoras: IETF, RFC 1422).
  - SSL (Secure Socket Layer)
    - Segurança para conexoes TCP
    - Confidencialidade
    - Integridade
    - Autenticidade end-point
    - Conexao:
      - Handshake: 
        - similar ao HTTP
        - SSL Hello
        - Geração de uma Master Secret Key
      - Key derivation
      - Data Transfer
  - Lei Geral de Proteção dos Dados
## WebSocket 
  - Problemas da Web App
    - Conexões subjacentes
    - Alto overhead
    - Mapeamento via script
  - Conexão Bidirecional entre cliente e servidor onde ambos podem enviar e receber dados.
  - **Protocolo via API que utiliza toda a infraestrutura do HTTP, dando um upgrade na conexão**
  - Voltada para aplicações em tempo real, onde informações são enviadas constantemente.
  - O protocolo fornece comunicação cliente/servidor executando um código não confiável(a propria aplicação) em um ambiente controlado para o host que escolheu essa comunicação.
  - Modelo Orign-base security
  - Endereçamento e protocolo

## Conexão Internet
  • Proxy
  • HTTP server

  • DNS – Domain Name System
  • Socket
  • Load balancer (controle de multiplas conexoes simultaneas de diferentes pontos)