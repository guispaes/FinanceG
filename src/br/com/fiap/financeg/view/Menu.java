package br.com.fiap.financeg.view;

import java.util.Scanner;
import br.com.fiap.financeg.model.*;

public class Menu {

    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        Usuario usuarioAtivo = null;
        CartaoDeCredito cartaoAtivo = null;

        System.out.println("    _______                                ______\n" +

                "   / ____(_)___  ____ _____  ________     / ____/\n" +

                "  / /_  / / __ \\/ __ `/ __ \\/ ___/ _ \\   / / __\n" +

                " / __/ / / / / / /_/ / / / / /__/  __/  / /_/ /\n" +

                "/_/   /_/_/ /_/\\__,_/_/ /_/\\___/\\___/   \\____/");

        do {
            if (usuarioAtivo == null) {
                System.out.println("\nMenu Inicial:");
                System.out.println("1 - Cadastrar Usuário");
                System.out.println("2 - Sair");
                System.out.print("Escolha uma opção: ");

                opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    System.out.print("\nDigite o nome do usuário: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o CPF: ");
                    String cpf = sc.nextLine();

                    usuarioAtivo = new Usuario(nome, cpf, 0.0);
                    cartaoAtivo = new CartaoDeCredito("5555 0000 1111 2222", "000", 600.0);

                    System.out.println("\n✅ Conta criada com sucesso para " + nome + "!");
                    System.out.println("🎉 Você recebeu um cartão de crédito pré-aprovado com R$ 600.00 de limite.");
                } else if (opcao == 2) {
                    System.out.println("\nEncerrando o sistema...");
                    break;
                } else {
                    System.out.println("\nOpção inválida!");
                }
            } else {
                System.out.println("\n--- Área do Usuário Logado: " + usuarioAtivo.getNome() + " ---");
                System.out.println("1 - Consultar Saldo");
                System.out.println("2 - Receber Dinheiro (Depositar)");
                System.out.println("3 - Realizar Transação (Usar Saldo da Conta)");
                System.out.println("4 - Usar Cartão de Crédito");
                System.out.println("5 - Simular Rendimento de Investimento");
                System.out.println("6 - Fazer Logout");
                System.out.print("Escolha uma opção: ");

                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println();
                        System.out.println("Saldo atual de " + usuarioAtivo.getNome() + ": R$ " + usuarioAtivo.getSaldoConta());
                        break;
                    case 2:
                        System.out.print("\nDigite o valor que deseja receber/depositar: R$ ");
                        double valorDep = sc.nextDouble();

                        // Instanciamos uma transação genérica para gerenciar o depósito
                        Transacao transacaoDep = new Transacao(valorDep, "Depósito em conta", "Depósito");
                        transacaoDep.depositar(usuarioAtivo, valorDep);
                        break;
                    case 3:
                        System.out.print("\nDigite o tipo de transação (Ex: PIX, Boleto): ");
                        String tipo = sc.nextLine();

                        System.out.print("Digite a descrição da transação: ");
                        String desc = sc.nextLine();

                        System.out.print("Digite o valor da transação: R$ ");
                        double valorTransacao = sc.nextDouble();

                        //
                        Transacao transacao = new Transacao(valorTransacao, desc, tipo);

                        if (transacao.usarSaldo(usuarioAtivo, valorTransacao)) {
                            transacao.processarTransacao();
                            transacao.emitirComprovante();
                        }
                        break;
                    case 4:
                        System.out.print("\nDigite o valor da compra no cartão de crédito: R$ ");
                        double valorCompra = sc.nextDouble();
                        cartaoAtivo.realizarCompraCredito(valorCompra);
                        break;
                    case 5:
                        System.out.println("\n[ ATENÇÃO: Os valores abaixo são apenas para simulação ]");
                        System.out.print("Digite o tipo de investimento (Ex: CDB, Ações): ");
                        String tipoInv = sc.nextLine();

                        System.out.print("Digite o valor que deseja simular: R$ ");
                        double valorInv = sc.nextDouble();

                        System.out.print("Digite a taxa de rendimento ANUAL esperada (%): ");
                        double taxa = sc.nextDouble();

                        Investimento simulacao = new Investimento(tipoInv, valorInv, taxa);
                        simulacao.simularAplicacao();
                        simulacao.calcularRendimentos();
                        break;
                    case 6:
                        System.out.println("\nFazendo logout... Até a próxima!");
                        usuarioAtivo = null;
                        cartaoAtivo = null;
                        break;
                    default:
                        System.out.println("\nOpção inválida! Tente novamente.");
                }
            }
        } while (true);

        sc.close();
    }
}