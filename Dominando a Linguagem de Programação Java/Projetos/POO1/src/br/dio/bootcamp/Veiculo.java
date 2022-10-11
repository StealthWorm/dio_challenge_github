package br.dio.bootcamp;

public class Veiculo {
    String cor;
    String modelo;
    int capacidade;

    public Veiculo() {
    }

    public Veiculo(String cor, String modelo, int capacidade) {
        this.cor = cor;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Double calcularTotalGasto(double valor) {
        return valor * capacidade;
    }

    @Override
    public String toString() {
        return "{" +
                "cor='" + cor + '\'' +
                ", modelo='" + modelo + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}
