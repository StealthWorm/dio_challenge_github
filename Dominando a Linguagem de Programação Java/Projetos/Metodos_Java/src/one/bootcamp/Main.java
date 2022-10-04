package one.bootcamp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //CALCULADORA
        System.out.println("Calculadora");
        Scanner scan = new Scanner(System.in);
        double a, b;
        System.out.println("Digite o Primeiro número");
        a = scan.nextDouble();
        System.out.println("Digite o Segundo número");
        b = scan.nextDouble();

        Calculadora.somar(a, b);
        Calculadora.subtrair(a, b);
        Calculadora.multiplicar(a, b);
        Calculadora.dividir(a, b);

        System.out.println("\n");

        //MENSAGEM
        System.out.println("Mensagem");
        Mensagem.mostrarMensagem(9);
        Mensagem.mostrarMensagem(15);
        Mensagem.mostrarMensagem(23);
        Mensagem.mostrarMensagem(0);

        System.out.println("\n");

        //EMPRÉSTIMO
        System.out.println("Empréstimo");
        Emprestimo.calcular(1000, Emprestimo.getDuasParcelas());
        Emprestimo.calcular(1000, Emprestimo.getTresParcelas());
        Emprestimo.calcular(1000, 5);

        System.out.println("\n");

        //SOBRECARGA
        System.out.println("Teste de sobrecarga de métodos");
//        Quadrilatero.area(2);
//        Quadrilatero.area(4d, 5d);
//        Quadrilatero.area(6f, 6f, 4f);

        System.out.println("Área do quadrado: " + Quadrilatero.area(2));
        System.out.println("Área do retângulo: " + Quadrilatero.area(4d, 5d));
        System.out.println("Área do trapézio: " + Quadrilatero.area(6f, 6f, 4f));
    }
}
