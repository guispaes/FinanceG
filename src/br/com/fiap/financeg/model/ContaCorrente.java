package br.com.fiap.financeg.model;

public class ContaCorrente extends Conta {

    private double limiteChequeEspecial;

    // Construtor vazio
    public ContaCorrente() {
        super();
    }

    // Construtor com parametros
    public ContaCorrente(int numero, String agencia, double saldo, double limiteChequeEspecial) {
        super(numero, agencia, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // Getters
    public double getLimiteChequeEspecial() { return limiteChequeEspecial; }

    // Setters
    public void setLimiteChequeEspecial(double limiteChequeEspecial) { this.limiteChequeEspecial = limiteChequeEspecial; }

    // Metodo especifico da conta corrente
    public void usarChequeEspecial(double valor) {
        double saldoTotal = getSaldo() + limiteChequeEspecial;

        if (valor <= saldoTotal) {
            setSaldo(getSaldo() - valor);
            System.out.println("Valor usado do cheque especial. Saldo atual: R$ " + getSaldo());
        } else {
            System.out.println("Limite insuficiente.");
        }
    }
}