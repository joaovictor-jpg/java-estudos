package projeto;

public class Conta {
    private String nome;
    private TypeConta conta;
    private double saldo;

    public Conta() {
    }

    public Conta(String nome, TypeConta conta, double saldo) {
        this.nome = nome;
        this.conta = conta;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TypeConta getConta() {
        return conta;
    }

    public void setConta(TypeConta conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void deposito(double deposito) {
        this.saldo += deposito;
    }

    public void transferencia(double saldo) {
        this.saldo -= saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", conta=" + conta +
                ", saldo=" + saldo +
                '}';
    }
}
