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
