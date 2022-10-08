package ExemploRefactorStream;

import java.util.Objects;

public class Contato {
    private String nome;
    private Integer numero;

    public Contato(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Contato contato = (Contato) o;
            return this.nome.equals(contato.nome) && this.numero.equals(contato.numero);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.nome, this.numero});
    }

    public String toString() {
        return "Contato{nome='" + this.nome + "', numero='" + this.numero + "'}";
    }
}
