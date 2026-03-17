package br.com.fiap.financeg.model;

public class Conta {

    private int numero;
    private String agencia;
    private double saldo;

    // Construtor vazio
    public Conta() {
    }

    // Construtor com parametros
    public Conta(int numero, String agencia, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    // Getters
    public int getNumero() { return numero; }
    public String getAgencia() { return agencia; }
    public double getSaldo() { return saldo; }

    // Setters
    public void setNumero(int numero) { this.numero = numero; }
    public void setAgencia(String agencia) { this.agencia = agencia; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    // Metodos de operacao
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito realizado. Saldo atual: R$ " + saldo);
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado. Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}