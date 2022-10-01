package br.com.dio;

public class Variaveis {
    public static void main(String[] args) {

        // nomenclatura de var
        int numeroTentativas;
        int I;
        int _1a;
        int $aq;

        numeroTentativas = 5;
        I = 10;
        _1a = 20;
        $aq = 7;
        final int NUMERO_TENTATIVAS = 10; //valores final nao podem ser alterados

        // tipos de dados
        byte b1 = 10;
        short s1 = 20000;
        long l1 = 1000000000000000000L;
        float f1 = 4.5f;
        double d1 = 85.79d; //double é maior que float
        boolean bool1 = true;
        char c1 = 'T';
        String str1 = "Teste";

        //Operadores Aritméticos
        System.out.println("PrePos");
        prePos();
        System.out.println("Aritmético");
        aritm();
        System.out.println("Atribuição");
        atrib();
        System.out.println("Precedência");
        preced();

        //Casting
        byte b2;
        short s2 = 1000;
        b2 = (byte) s2;

        long l2;
        int i2 = 100;
        l2 = i2;

        float f2;
        float f3;
        double d2 = 10000.58d;
        f2 = (float) d2;

        System.out.println(b2);
        System.out.println(f2);
    }

    private static void prePos() {
        int k = 10;

        int i = ++k;
        int j = k--;
        int x = k;

        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("k: " + k);
    }

    private static void aritm() {
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        int e = 50;

        int r1 = a + b;
        int r2 = c - a;
        int r3 = d * b;
        int r4 = e / a;
        int r5 = c % b;

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);
        System.out.println("r3: " + r3);
        System.out.println("r4: " + r4);
        System.out.println("r5: " + r5);
    }

    private static void atrib() {
        int i = 1500;
        short j = 15;
        long l = 500L;
        int k = 35;
        float f = 3.5f;
        double d = f;

        System.out.println("d: " + d);

        i += 5;    // i = i + 5
        j -= 3;    // j = j - 3
        d /= 2.7d; // d = d / 2.7d
        l *= 3;    // l = l * 3
        k %= 2;    // k = k % 2

        System.out.println("i: " + i);
        System.out.println("j: " + j);
        System.out.println("d: " + String.format("%.2f", d));
        System.out.println("l: " + l);
        System.out.println("k: " + k);

        i = k = j;

        System.out.println("k: " + k);
        System.out.println("i: " + i);
    }

    private static void preced() {
        int i = 10;
        int j = 20;
        int k = 30;

        int a = i++ + --j * k; // 10 + 19 * 30

        System.out.println("i++ + --j * k : " + a);
        System.out.println("i: " + i); // 11

        int b = k / --i % 3 + 1; // 30 / 10 % 3 + 1

        System.out.println("k / --i % 3  +1: " + b);
        System.out.println("i: " + i); //10

        int c = 2;
        c *= i += 5; //c = 2 * i; i = i + 5; ->  i = 10 + 5; ->  c = 2 * 15 = 30

        System.out.println("c *= i += 5: " + c);
        System.out.println("i: " + i);
    }

}
