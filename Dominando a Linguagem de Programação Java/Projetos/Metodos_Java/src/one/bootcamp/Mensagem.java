package one.bootcamp;

public class Mensagem {

    public static void mostrarMensagem(int hora){
        if(hora >= 0) {
            if(hora >= 5 && hora <= 12) {
                mensagemBomDia();
            } else if (hora >= 6 && hora <= 17) {
                mensagemBoaTarde();
            } else if ((hora >= 18 && hora <= 23) || hora <= 4) {
                mensagemBoaNoite();
            }
        } else {
            System.out.println("Digite um horário válido!!");
        }
    }

    public static void mensagemBomDia() {
        System.out.println("Bom dia!!\n");
    }
    public static void mensagemBoaTarde() {
        System.out.println("Boa tarde!!\n");
    }
    public static void mensagemBoaNoite() {
        System.out.println("Boa noite!!\n");
    }
}
