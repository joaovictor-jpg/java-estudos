package modal;

public class ContaBancaria {

    private String titular;
    private int numeroConta;
    protected double saldo;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double saldo) {
        this.saldo += saldo;
    }

    public double sacar(double sacar) {
        if (this.saldo > sacar) {
            this.saldo -= sacar;
        } else {
            System.out.println("Saldo insuficente");
        }
        return saldo;
    }
}
