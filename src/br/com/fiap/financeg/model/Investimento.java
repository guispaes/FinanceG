package br.com.fiap.financeg.model;

public class Investimento {
    private String tipoInvestimento;
    private double valorAplicado;
    private double taxaRendimentoAnual;

    // Construtor
    public Investimento() {
    }

    // Construtor com parâmetros
    public Investimento(String tipoInvestimento, double valorAplicado, double taxaRendimentoAnual) {
        this.tipoInvestimento = tipoInvestimento;
        this.valorAplicado = valorAplicado;
        this.taxaRendimentoAnual = taxaRendimentoAnual;
    }

    // Head padrão do simulador de investimentos.
    public void simularAplicacao() {
        System.out.println("\n--- MÓDULO DE SIMULAÇÃO DE INVESTIMENTO ---");
        System.out.println("Iniciando simulação para R$ " + valorAplicado + " em " + tipoInvestimento);
    }

    // Cálculo de juros simples para a simulação
    public void calcularRendimentos() {
        double rendimentoAnual = valorAplicado * (taxaRendimentoAnual / 100);
        double rendimentoMensal = rendimentoAnual / 12;
        double saldoFinal = valorAplicado + rendimentoAnual;

        System.out.println("Com uma taxa estipulada de " + taxaRendimentoAnual + "% ao ano, esta é a projeção:");
        System.out.printf("-> Rendimento estimado por MÊS: R$ %.2f\n", rendimentoMensal);
        System.out.printf("-> Rendimento estimado por ANO: R$ %.2f\n", rendimentoAnual);
        System.out.printf("-> Saldo total estimado após 1 ano: R$ %.2f\n", saldoFinal);
        System.out.println("-------------------------------------------");
    }
}