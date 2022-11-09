Soluções para problemas recorrentes no ambito do desenvolvimento 

Padrões Criacionais: Abstract Factory, Builder, Factory method, Prototype, **Singleton**
Padrões Comportamentais: Chain of Responsibility, Iterator, Observer, **Strategy Template**
Padrões Estruturais: Adapter, Bridge, Composite, Decorator, **Facade**, Flyweight, Proxy 

**SINGLETON**: Permitir a criação de uma unica instancia de uma classe e fornecer um modo para recupera-la. 
  @Bean, @Autowired
**STRATEGY**: Simplificar a variação de algoritmos para a resolução de um mesmo problema. Criação de interface de metodos , cujas classes de operação podem implementar e sobrescrever o comportamento padrão.
  @Service, @Repository
**FACADE**: Prever uma interface que reduza a complexidade nas integrações com subsistemas. Interface mais coesa para que varios clientes consumam. O facade abstrai a complexidade da integração de multiplas interfaces, para que um usuario nao tenha que se preocupar com as multiplas chamadas ou instancias diferentes, pois esta tudo centralizado.
  Feign