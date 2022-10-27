package dio.web.api.handler;

public class CamposObrigatoriosException extends BusinessException {
    public CamposObrigatoriosException(String campo) {
        super("O campo %s é obrigatório", campo);
    }
}
