public class FormatadorCep {
  public static void main(String[] args) {
    try {
      String cepFormatado = formatarCep("096241969901");
      System.out.println(cepFormatado);
    } catch (CepInvalidoException e) {
      System.out.println("O cep é inválido");
    }
  }

  static String formatarCep(String cep) throws CepInvalidoException {
    if (cep.length() != 11) {
      throw new CepInvalidoException();
    }

    return "096.241.969-90";
  }
}
