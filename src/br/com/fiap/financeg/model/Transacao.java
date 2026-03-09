package br.com.fiap.financeg.model;

public class Transacao {
    private double valor;
    private String descricao;
    private String tipo;

    // Construtor
    public Transacao() {
    }

    // Construtor com parâmetros
    public Transacao(double valor, String descricao, String tipo) {
        this.valor = valor;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    // Receber/Depositar dinheiro
    public void depositar(Usuario usuario, double valor) {
        if (valor > 0) {
            double novoSaldo = usuario.getSaldoConta() + valor;
            usuario.setSaldoConta(novoSaldo);
            System.out.println("Depósito de R$ " + valor + " recebido com sucesso! Novo saldo: R$ " + novoSaldo);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Fazer transferência
    public boolean usarSaldo(Usuario usuario, double valor) {
        double saldoAtual = usuario.getSaldoConta();

        if (saldoAtual == 0 || valor > saldoAtual) {
            System.out.println("Transação negada! Saldo insuficiente. Seu saldo atual é de R$ " + saldoAtual);
            return false;
        }

        double novoSaldo = saldoAtual - valor;
        usuario.setSaldoConta(novoSaldo);
        System.out.println("Transação autorizada! Novo saldo: R$ " + novoSaldo);
        return true;
    }

    // "SOUT"s para complementar a transação
    public void processarTransacao() {
        System.out.println("Processando " + tipo + " no valor de R$ " + valor);
    }

    public void emitirComprovante() {
        System.out.println("Gerando recibo para a transação: " + descricao);
    }
}