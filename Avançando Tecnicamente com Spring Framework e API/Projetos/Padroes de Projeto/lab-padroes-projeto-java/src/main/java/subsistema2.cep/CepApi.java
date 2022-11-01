package subsistema2.cep;

import org.dio.gof.singleton.SingletonEager;

public class CepApi {
    private static CepApi instancia = new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance() {
        return instancia;
    }

    public String recuperarCidade(String cep) {
        return "Cidade teste";
    }
    public String recuperarEstado(String cep) {
        return "SP";
    }
}
