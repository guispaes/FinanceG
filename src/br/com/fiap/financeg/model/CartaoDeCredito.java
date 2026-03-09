package br.com.fiap.financeg.model;

public class CartaoDeCredito {
    private String numero;
    private String cvv;
    private double limiteTotal;
    private double limiteDisponivel;

    // Construtor
    public CartaoDeCredito() {
    }

    // Construtor com parâmetros
    public CartaoDeCredito(String numero, String cvv, double limiteTotal) {
        this.numero = numero;
        this.cvv = cvv;
        this.limiteTotal = limiteTotal;
        this.limiteDisponivel = limiteTotal;
    }

    // Bloqueia/Aprova compras no cartão com base no limite atual
    public void realizarCompraCredito(double valor) {
        if (valor > limiteDisponivel) {
            System.out.println("Compra negada! Limite excedido. Limite disponível: R$ " + limiteDisponivel);
        } else {
            limiteDisponivel -= valor;
            System.out.println("Compra de R$ " + valor + " aprovada no cartão final " + numero.substring(numero.length() - 4) + ". Limite restante: R$ " + limiteDisponivel);
        }
    }
}
