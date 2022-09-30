package br.com.dio;

import br.com.dio.model.Gato;

import java.util.Objects;

public class PrimeiroPrograma {
    public static void main(String[] args) {
        Gato gato = new Gato();
        System.out.println(gato);

        Livro livro = new Livro("O Hobbit", 400);
        System.out.println(livro);

        //        int a = 5;
        //        int b = 5;
        //        System.out.println("Hello World" + ());
    }
}

class Livro {
    private String nome;
    private Integer numPages;

    public Livro(String nome, Integer numPages) {
        this.nome = nome;
        this.numPages = numPages;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", numPages=" + numPages +
                '}';
    }
}
