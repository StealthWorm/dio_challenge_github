package one.bootcamp;


public class Calculadora {
    public static void somar(double a, double b) {
        double result = a + b;
        System.out.println("A soma de " + a + " com " + b + " é : " + result);
    }

    public static void subtrair(double a, double b) {
        double result = a - b;
        System.out.println("A subtração de " + a + " com " + b + " é : " + result);
    }

    public static void multiplicar(double a, double b) {
        double result = a * b;
        System.out.println("A multiplicação de " + a + " com " + b + " é : " + result);
    }

    public static void dividir(double a, double b) {
        double result = a / b;
        System.out.println("A divisão de " + a + " com " + b + " é : " + result);
    }
}
