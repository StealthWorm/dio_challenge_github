package vendas;

public class App {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        Funcionario gerente = new Gerente();
        Funcionario vendedor = new Vendedor();
        Funcionario faxineiro = new Faxineiro();

        // baixando a hierarquia do Funcionario (pai) para um tipo filho (Vendedor)
        // Downcast deve ser evitado em POO, ao contrario de variaveis.
//        Vendedor v1 = (Vendedor) new Funcionario();


    }
}
