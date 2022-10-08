package ExemploRefactorStream;

import java.io.PrintStream;
import java.util.*;
import java.util.function.Function;

public class ExercicioContatos {

    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("John", 2222));
            put(6, new Contato("John", 2222));
            put(8, new Contato("America", 9999));
        }};
        System.out.println(agenda);
        Iterator var2 = agenda.entrySet().iterator();

        PrintStream var10000;
        Object var10001;
        while (var2.hasNext()) {
            Map.Entry<Integer, Contato> entry = (Map.Entry) var2.next();
            var10000 = System.out;
            var10001 = entry.getKey();
            var10000.println("" + var10001 + " - " + ((Contato) entry.getValue()).getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>() {{
            put(1, new Contato("Simba", 5555));
            put(4, new Contato("Cami", 1111));
            put(3, new Contato("John", 2222));
            put(6, new Contato("John", 2222));
            put(8, new Contato("America", 9999));
        }};
        System.out.println(agenda1);
        Iterator var9 = agenda1.entrySet().iterator();

        while (var9.hasNext()) {
            Map.Entry<Integer, Contato> entry = (Map.Entry) var9.next();
            var10000 = System.out;
            var10001 = entry.getKey();
            var10000.println("" + var10001 + " - " + ((Contato) entry.getValue()).getNome());
        }

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap(agenda);
        System.out.println(agenda2);
        Iterator var11 = agenda2.entrySet().iterator();

        while (var11.hasNext()) {
            Map.Entry<Integer, Contato> entry = (Map.Entry) var11.next();
            var10000 = System.out;
            var10001 = entry.getKey();
            var10000.println("" + var10001 + " - " + ((Contato) entry.getValue()).getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");
        //exemplo classe anonima, o corpo do Comparator é declarado diretamente na chamada
//        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
//                return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
//            }
//        });

        //exemplo Functional Interface, o método "comparing" permite fazer comparalçoes passando uma Interface funcional "Function". Como ele esta instanciando a interface não preceisa declarar como "new Comparator"
//        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
//            // o segundo argumento é o tipo do campo que queremos testar, como é por Numero de Telefone, então é Integer
//            new Function<Map.Entry<Integer, Contato>, Integer>() {
//                @Override
//                public Integer apply(Map.Entry<Integer, Contato> cont) {
//                    return cont.getValue().getNumero();
//                }
//            }
//        ));

        // exemplo Lambda (argumento) -> (corpo), o "argumento da Function" -> "corpo do retorno da function"
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
        set.addAll(agenda.entrySet());
        Iterator var13 = set.iterator();

        while (var13.hasNext()) {
            Map.Entry<Integer, Contato> entry = (Map.Entry) var13.next();
            var10000 = System.out;
            var10001 = entry.getKey();
            var10000.println("" + var10001 + " - " + ((Contato) entry.getValue()).getNumero() + ": " + ((Contato) entry.getValue()).getNome());
        }

        System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome()));
        set1.addAll(agenda.entrySet());
        Iterator var15 = set1.iterator();

        while (var15.hasNext()) {
            Map.Entry<Integer, Contato> entry = (Map.Entry) var15.next();
            var10000 = System.out;
            var10001 = entry.getKey();
            var10000.println("" + var10001 + " - " + ((Contato) entry.getValue()).getNome());
        }

    }
}

//class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
//    @Override
//    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
//        return Integer.compare(c1.getValue().getNumero(), c2.getValue().getNumero());
//    }
//}

//class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
//    @Override
//    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
//        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
//    }
//}
