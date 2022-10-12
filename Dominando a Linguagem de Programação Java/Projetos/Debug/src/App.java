import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Metodo MAIN");
        JOptionPane.showMessageDialog(null, "hello world", "hello", 0);
        a();
        System.out.println("finalizaou MAIN");
    }

    static void a() {
        System.out.println("Metodo a");
        b();
        System.out.println("terminou metodo a");
    }

    static void b() {
        System.out.println("Metodo b");
        c();
        System.out.println("terminou metodo b");
    }

    static void c() {
        System.out.println("Metodo c");
        // Thread.dumpStack();
        System.out.println("terminou metodo c");
    }
}
