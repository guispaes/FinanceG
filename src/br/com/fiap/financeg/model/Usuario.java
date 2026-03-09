package br.com.fiap.financeg.model;

public class Usuario {
    private String nome;
    private String cpf;
    private double saldoConta;

    // Construtor
    public Usuario() {
    }

    // Construtor com parâmetros
    public Usuario(String nome, String cpf, double saldoConta) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldoConta = saldoConta;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    // Setters
    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

}