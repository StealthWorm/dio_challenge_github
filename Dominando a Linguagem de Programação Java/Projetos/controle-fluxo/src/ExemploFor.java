public class ExemploFor {
  public static void main(String[] args) {
    String alunos[] = { "Joao", "Juca", "Ana", "Felipe", "Jessica" };

    // varredura de constante
    for (int i = 0; i < 20; i++) {
      System.out.println(i);
    }

    // varredura de arrays
    for (int i = 0; i < alunos.length; i++) {
      System.out.println(alunos[i]);
    }

    // for each
    for (String aluno : alunos) {
      if(aluno == "Felipe") {
        continue; // continue só pula a iteração que respeita a condição, mas continua o loop, o break ele para a execução do loop
      }
      System.out.println("Nome do aluno é : " + aluno);
    }
  }
}
