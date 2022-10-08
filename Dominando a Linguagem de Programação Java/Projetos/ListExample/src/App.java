import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        int N[] = new int[10];
        int t = 2;

        for (int i = 0; i <= N.length; i++) {
            for (int j = 0; j <= (t); j++) {
                if (j <= t - 1 && i < N.length) {
                    System.out.println("N[" + i + "] = " + j);
                    i++;
                } else if (i < N.length) {
                    i--;
                }
            }
        }
    }
}
