package br.com.fiap.financeg.model;

public class Transacao {

    private double valor;
    private String descricao;
    private String tipo;

    // Construtor vazio
    public Transacao() {
    }

    // Construtor com parametros
    public Transacao(double valor, String descricao, String tipo) {
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    // Getters
    public double getValor() { return valor; }
    public String getDescricao() { return descricao; }
    public String getTipo() { return tipo; }

    // Setters
    public void setValor(double valor) { this.valor = valor; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    // Metodos
    public void processarTransacao() {
        System.out.println("Processando " + tipo + " no valor de R$ " + valor);
    }

    public void emitirComprovante() {
        System.out.println("Gerando comprovante da transacao: " + descricao);
    }
}