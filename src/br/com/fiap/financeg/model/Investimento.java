package br.com.fiap.financeg.model;

public class Investimento extends Transacao {

    private String tipoInvestimento;
    private double taxaRendimentoAnual;

    // Construtor vazio
    public Investimento() {
    }

    // Construtor com parametros
    public Investimento(double valor, String descricao, String tipo, String tipoInvestimento, double taxaRendimentoAnual) {
        super(valor, descricao, tipo);
        this.tipoInvestimento = tipoInvestimento;
        this.taxaRendimentoAnual = taxaRendimentoAnual;
    }

    // Getters
    public String getTipoInvestimento() { return tipoInvestimento; }
    public double getValorAplicado() { return getValor(); }
    public double getTaxaRendimentoAnual() { return taxaRendimentoAnual; }

    // Setters
    public void setTipoInvestimento(String tipoInvestimento) { this.tipoInvestimento = tipoInvestimento; }
    public void setValorAplicado(double valorAplicado) { this.setValor(valorAplicado); }
    public void setTaxaRendimentoAnual(double taxaRendimentoAnual) { this.taxaRendimentoAnual = taxaRendimentoAnual; }

    // Metodo para iniciar a simulacao
    public void simularAplicacao() {
        System.out.println("\n--- MODULO DE SIMULACAO DE INVESTIMENTO ---");
        System.out.println("Iniciando simulacao para R$ " + getValor() + " em " + tipoInvestimento);
    }

    // Calculo de rendimento anual e mensal
    public void calcularRendimentos() {
        double rendimentoAnual = getValor() * (taxaRendimentoAnual / 100);
        double rendimentoMensal = rendimentoAnual / 12;
        double saldoFinal = getValor() + rendimentoAnual;

        System.out.println("Com uma taxa estipulada de " + taxaRendimentoAnual + "% ao ano, esta e a projecao:");
        System.out.printf("-> Rendimento estimado por MES: R$ %.2f%n", rendimentoMensal);
        System.out.printf("-> Rendimento estimado por ANO: R$ %.2f%n", rendimentoAnual);
        System.out.printf("-> Saldo total estimado apos 1 ano: R$ %.2f%n", saldoFinal);
        System.out.println("-------------------------------------------");
    }
}