package br.com.fiap.financeg.model;

public class CartaoDeCredito {

    private String numero;
    private String cvv;
    private double limiteTotal;
    private double limiteDisponivel;

    // Construtor vazio
    public CartaoDeCredito() {
    }

    // Construtor com parametros
    public CartaoDeCredito(String numero, String cvv, double limiteTotal) {
        this.numero = numero;
        this.cvv = cvv;
        this.limiteTotal = limiteTotal;
        this.limiteDisponivel = limiteTotal;
    }

    // Getters
    public String getNumero() { return numero; }
    public String getCvv() { return cvv; }
    public double getLimiteTotal() { return limiteTotal; }
    public double getLimiteDisponivel() { return limiteDisponivel; }

    // Setters
    public void setNumero(String numero) { this.numero = numero; }
    public void setCvv(String cvv) { this.cvv = cvv; }
    public void setLimiteTotal(double limiteTotal) { this.limiteTotal = limiteTotal; }
    public void setLimiteDisponivel(double limiteDisponivel) { this.limiteDisponivel = limiteDisponivel; }

    // Metodo para realizar compra no credito
    public void realizarCompraCredito(double valor) {
        if (valor > limiteDisponivel) {
            System.out.println("Compra negada! Limite excedido. Limite disponivel: R$ " + limiteDisponivel);
        } else {
            limiteDisponivel -= valor;
            System.out.println("Compra de R$ " + valor + " aprovada no cartao final " + numero.substring(numero.length() - 4) + ". Limite restante: R$ " + limiteDisponivel);
        }
    }
}