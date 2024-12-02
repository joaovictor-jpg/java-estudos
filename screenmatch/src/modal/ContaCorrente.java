package modal;

public class ContaCorrente extends ContaBancaria{
    public void cobrarTarifaMensal(double tarifaMensal) {
        this.saldo -= tarifaMensal;
    }
}
