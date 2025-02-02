package br.com.jota.entities;

import java.math.BigDecimal;

public class Conta {
    private String nome;
    private String agencia;
    private BigDecimal saldo;
    private Integer numero;

    public Conta(String nome, String agencia, BigDecimal saldo, Integer numero) {
        this.nome = nome;
        this.agencia = agencia;
        this.saldo = saldo;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Olá " + nome + ", obrigado por criar uma conta em nosso banco, sua agência é " + agencia + ", conta "
                + numero + " e seu saldo  " + saldo + " já está disponivel para saque.";
    }

}
