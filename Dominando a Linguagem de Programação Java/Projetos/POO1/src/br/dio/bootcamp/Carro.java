package br.dio.bootcamp;

class Carro extends Veiculo{
    public Carro() {}

    public Carro(String cor, String modelo, int capacidade) {
        this.cor = cor;
        this.modelo = modelo;
        this.capacidade = capacidade;
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
