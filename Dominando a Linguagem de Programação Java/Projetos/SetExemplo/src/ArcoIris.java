import java.util.*;

public class ArcoIris {
    public static void main(String[] args) {
        System.out.println("Crie uma conjunto contendo as cores do arco-íris: ");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("violeta");
        coresArcoIris.add("anil");
        coresArcoIris.add("azul");
        coresArcoIris.add("verde");
        coresArcoIris.add("amarelo");
        coresArcoIris.add("laranja");
        coresArcoIris.add("vermelho");
        System.out.println(coresArcoIris);

        //A
        System.out.println("Exiba todas as cores o arco-íris uma abaixo da outra: ");
        for (String cor : coresArcoIris) {
            System.out.println(cor);
        }
        System.out.println("\n");

        //B
        System.out.println("A quantidade de cores que o arco-íris tem: " + coresArcoIris.size());
        System.out.println("\n");

        //C
        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> coresAlfabetica = new TreeSet<>(coresArcoIris);
        System.out.println(coresAlfabetica);
        System.out.println("\n");

        //D
        System.out.println("Exiba as cores na ordem inversa da que foi informada: ");
//        Set<String> coresArcoIris2 = new LinkedHashSet<>(Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelho"));
        Set<String> coresArcoIris2 = new LinkedHashSet<>(coresArcoIris);
        List<String> listaCoresReverso = new ArrayList<>(coresArcoIris2);
        Collections.reverse(listaCoresReverso);
        System.out.println(listaCoresReverso);
        System.out.println("\n");

        //E
        System.out.println("Exiba todas as cores que começam com a letra ”v”: ");
        for (String cor : coresArcoIris) {
            if (cor.startsWith("v")) {
                System.out.println(cor);
            }
        }
        System.out.println("\n");

        //F
        System.out.println("Remova todas as cores que começam com a letra ”v”: ");
        Iterator<String> iterator = coresArcoIris.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("v")) {
                iterator.remove();
            }
        }
        System.out.println(coresArcoIris);
        System.out.println("\n");

        //G
        System.out.println("Limpe o conjunto: ");
        coresArcoIris.clear();
        System.out.println(coresArcoIris);
        System.out.println("\n");

        //H
        System.out.println("Confira se o conjunto está vazio:");
        System.out.println(coresArcoIris.isEmpty());
        System.out.println("\n");

    }
}
