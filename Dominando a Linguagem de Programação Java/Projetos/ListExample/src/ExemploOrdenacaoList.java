import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> gatos = new ArrayList<>() {{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Jon", 18, "azul"));
            add(new Gato("Simba", 6, "listrado"));
            add(new Gato("Armin", 12, "amarelo"));
        }};

        System.out.println("--\tOrdem de Insercao\t--");
        System.out.println(gatos);

        System.out.println("--\tOrdem Aleatoria\t--");
        Collections.shuffle(gatos);
        System.out.println(gatos);

        System.out.println("--\tOrdem Aleatoria\t--");
        Collections.shuffle(gatos);
        System.out.println(gatos);

        // ordenar por ordem natural precisa implementar o Comparable
        // nesse caso o comparable esta utilizando uma string com ignoreCase e retornando um Inteiro (retorna 1 quando o valor 1 for maior que o valor 2 , -1 quando for menor e 0 quando for igual)
        System.out.println("--\tOrdem Natural (Nome)\t--");
        Collections.sort(gatos);
        System.out.println(gatos);

        System.out.println("--\tOrdem Idade\t--");
//        Collections.sort(gatos, new ComparatorIdade());
        gatos.sort(new ComparatorIdade());
        System.out.println(gatos);

        System.out.println("--\tOrdem Cor\t--");
//        Collections.sort(gatos, new ComparatorIdade());
        gatos.sort(new ComparatorCor());
        System.out.println(gatos);

        // estamos definindo pra ele comparar primeiro o nome, depois a cor e depois a idade, nessa ordem
        System.out.println("--\tOrdem Nome->Cor->idade\t--");
        gatos.sort(new ComparatorTodos());
        System.out.println(gatos);
    }
}

class Gato implements Comparable<Gato> {
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        //utiliza o "this" pois esta dentro da classe Gato
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorTodos implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        //se os nomes forem diferentes retorne por nome
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        //se as cores forem diferentes retorne por cor
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        // senão, se nome e cor forem iguais, retorne por idade
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}
