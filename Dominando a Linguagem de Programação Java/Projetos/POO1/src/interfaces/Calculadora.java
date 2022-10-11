package interfaces;

public class Calculadora implements OperacaoMatematica{
    // ao declarar o "implements" ele te obriga a implementar os metodos obrigatorios da Interface, para estabelecer o Contrato
    @Override
    public void soma(double v1, double v2) {
        System.out.println(v1+v2);
    }

    @Override
    public void subtracao(double v1, double v2) {
        System.out.println(v1-v2);
    }

    @Override
    public void multiplicacao(double v1, double v2) {
        System.out.println(v1*v2);
    }

    @Override
    public void divisao(double v1, double v2) {
        System.out.println(v1/v2);
    }
}
