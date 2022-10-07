import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

      System.out.println("Digite seu nome");
      String nome = scanner.next();

      System.out.println("Digite seu sobrenome");
      String sobrenome = scanner.next();

      System.out.println("Digite sua idade");
      int idade = scanner.nextInt();

      System.out.println("Digite sua  altura");
      double altura = scanner.nextDouble();

      System.out
          .println("Me chamo " + nome + " " + sobrenome + ", tenho " + idade + " anos e " + altura + " de altura.");
      scanner.close();
    } catch (InputMismatchException e) {
      System.err.println("O campos idade e/ou altura precisam ser numéricos.");
    }
  }
}
