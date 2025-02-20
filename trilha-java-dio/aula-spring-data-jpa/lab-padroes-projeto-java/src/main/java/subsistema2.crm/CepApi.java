package subsistema2.crm;

import br.com.jota.gof.Singleton.SingletonLazy;

public class CepApi {
    private static CepApi instancia;

    private CepApi() {
        super();
    }

    public static CepApi getInstance() {
        if (instancia == null) {
            instancia = new CepApi();
            return instancia;
        }
        return instancia;
    }

    public String recuperarCidade(String cep) {
        return "Araraquara";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}
