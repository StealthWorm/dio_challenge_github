import java.util.concurrent.ThreadLocalRandom;

public class ExemploWhile {
  public static void main(String[] args) {
    double mesada = 50.0;

    while (mesada > 0) {
      Double valorDoce = valorAleatorio();

      if (valorDoce > mesada) {
        valorDoce = mesada;
      }

      System.out.println("Doce do valor: R$" + String.format("%.2f", valorDoce) + " Acicionado no carrinho");
      mesada -= valorDoce;
    }

    System.out.println("mesada: " + mesada);
  }

  private static double valorAleatorio() {
    return ThreadLocalRandom.current().nextDouble(2, 8);
  }
}
