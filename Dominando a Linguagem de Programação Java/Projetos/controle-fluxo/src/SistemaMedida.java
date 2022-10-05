public class SistemaMedida {
  public static void main(String[] args) {
    String sigla = "G";

    // não é tão performático, depende do caso pra usar
    switch (sigla) {
      case "P": {
        System.out.println("PEQUENO");
        break;
      }
      case "M": {
        System.out.println("MÉDIO");
        break;
      }
      case "G": {
        System.out.println("GRANDE");
        break;
      }
      default: {
        System.out.println("INDEFINIDO");
      }
    }

  }
}
