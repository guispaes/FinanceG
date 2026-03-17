package br.com.fiap.financeg.model;

public class Usuario {

    private String nome;

    // Construtor vazio
    public Usuario() {
    }

    // Construtor com parametros
    public Usuario(String nome) {
        this.nome = nome;
    }

    // Getters
    public String getNome() { return nome; }

    // Setters
    public void setNome(String nome) { this.nome = nome; }
}