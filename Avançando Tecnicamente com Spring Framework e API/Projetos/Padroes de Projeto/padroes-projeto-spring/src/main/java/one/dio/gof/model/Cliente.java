package one.dio.gof.model;

import javax.persistence.*;
import java.util.*;
import java.util.Observer;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Endereco endereco;
    @ElementCollection
    private List<Endereco> enderecos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;

        System.out.println("Lista de Endereços do cliente " + this.nome);
        for (Endereco end : this.enderecos) {
            end.update(this.getEndereco().getCep());
        }
    }

    public void subscribe(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void unsubscribe(Endereco endereco) {
        this.enderecos.remove(endereco);
    }
}
