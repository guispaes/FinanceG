package br.com.fiap.financeg.model;

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    // Construtor vazio
    public ContaPoupanca() {
        super();
    }

    // Construtor com parametros
    public ContaPoupanca(int numero, String agencia, double saldo, double taxaRendimento) {
        super(numero, agencia, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    // Getters
    public double getTaxaRendimento() { return taxaRendimento; }

    // Setters
    public void setTaxaRendimento(double taxaRendimento) { this.taxaRendimento = taxaRendimento; }

    // Metodo especifico da poupanca
    public void aplicarRendimento() {
        double rendimento = getSaldo() * (taxaRendimento / 100);
        setSaldo(getSaldo() + rendimento);

        System.out.println("Rendimento aplicado: R$ " + rendimento);
        System.out.println("Novo saldo: R$ " + getSaldo());
    }
}