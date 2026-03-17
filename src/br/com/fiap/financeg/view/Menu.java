package br.com.fiap.financeg.view;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import br.com.fiap.financeg.model.*;

public class Menu {

    // Lista de usuarios cadastrados
    private List<Login> listaLogins = new ArrayList<>();

    // Metodo de exibicao do menu
    public void exibirMenu() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        // Variaveis de sessao
        Login usuarioAtivo = null;
        ContaCorrente contaAtiva = null;
        CartaoDeCredito cartaoAtivo = null;

        System.out.println("    _______                                ______\n" +
                "   / ____(_)___  ____ _____  ________     / ____/\n" +
                "  / /_  / / __ \\/ __ `/ __ \\/ ___/ _ \\   / / __\n" +
                " / __/ / / / / / /_/ / / / / /__/  __/  / /_/ /\n" +
                "/_/   /_/_/ /_/\\__,_/_/ /_/\\___/\\___/   \\____/");

        // Loop principal
        do {
            if (usuarioAtivo == null) {
                // Menu Inicial de Acesso
                System.out.println("\nMenu Inicial:");
                System.out.println("1 - Cadastrar Novo Usuario");
                System.out.println("2 - Fazer Login");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opcao: ");

                opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    // Logica de cadastro
                    System.out.print("\nDigite o seu nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Crie um login de acesso: ");
                    String login = sc.nextLine();

                    System.out.print("Crie uma senha: ");
                    String senha = sc.nextLine();

                    listaLogins.add(new Login(nome, login, senha));

                    System.out.println("\nUsuario " + nome + " cadastrado com sucesso!");

                } else if (opcao == 2) {
                    // Logica de autenticacao
                    System.out.print("\nDigite seu login: ");
                    String loginBusca = sc.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senhaBusca = sc.nextLine();

                    for (Login l : listaLogins) {
                        if (l.autenticar(loginBusca, senhaBusca)) {
                            usuarioAtivo = l;
                            contaAtiva = new ContaCorrente(1001, "0001", 0.0, 500.0);
                            cartaoAtivo = new CartaoDeCredito("5555000011112222", "000", 600.0);
                            System.out.println("\nBem-vindo(a), " + usuarioAtivo.getNome() + "!");
                            break;
                        }
                    }

                    if (usuarioAtivo == null) {
                        System.out.println("\nLogin ou senha incorretos.");
                    }

                } else if (opcao == 3) {
                    System.out.println("\nEncerrando o sistema...");
                    break;
                } else {
                    System.out.println("\nOpcao invalida!");
                }
            } else {
                // Menu do Usuario Logado
                System.out.println("\n--- Área do Usuario Logado: " + usuarioAtivo.getNome() + " ---");
                System.out.println("1 - Consultar Saldo");
                System.out.println("2 - Receber Dinheiro (Depositar)");
                System.out.println("3 - Realizar Transacao (Usar Saldo da Conta)");
                System.out.println("4 - Usar Cartao de Credito");
                System.out.println("5 - Simular Rendimento de Investimento");
                System.out.println("6 - Fazer Logout");
                System.out.print("Escolha uma opcao: ");

                opcao = sc.nextInt();
                sc.nextLine();

                // Switch de operacoes
                switch (opcao) {
                    case 1:
                        System.out.println("\nSaldo atual: R$ " + contaAtiva.getSaldo());
                        break;

                    case 2:
                        System.out.print("\nDigite o valor que deseja receber/depositar: R$ ");
                        double valorDep = sc.nextDouble();
                        sc.nextLine();

                        contaAtiva.depositar(valorDep);
                        break;

                    case 3:
                        System.out.print("\nDigite o tipo de transacao (Ex: PIX, Boleto): ");
                        String tipo = sc.nextLine();

                        System.out.print("Digite a descricao da transacao: ");
                        String desc = sc.nextLine();

                        System.out.print("Digite o valor da transacao: R$ ");
                        double valorTransacao = sc.nextDouble();
                        sc.nextLine();

                        Transacao transacao = new Transacao(valorTransacao, desc, tipo);

                        if (valorTransacao <= contaAtiva.getSaldo()) {
                            contaAtiva.sacar(valorTransacao);
                            transacao.processarTransacao();
                            transacao.emitirComprovante();
                        } else {
                            System.out.println("Transacao negada! Saldo insuficiente.");
                        }
                        break;

                    case 4:
                        System.out.print("\nDigite o valor da compra no cartao de credito: R$ ");
                        double valorCompra = sc.nextDouble();
                        sc.nextLine();

                        cartaoAtivo.realizarCompraCredito(valorCompra);
                        break;

                    case 5:
                        System.out.println("\n[ ATENCAO: Os valores abaixo sao apenas para simulacao ]");

                        System.out.print("Digite o tipo de investimento (Ex: CDB, Acoes): ");
                        String tipoInv = sc.nextLine();

                        System.out.print("Digite o valor que deseja simular: R$ ");
                        double valorInv = sc.nextDouble();

                        System.out.print("Digite a taxa de rendimento ANUAL esperada (%): ");
                        double taxa = sc.nextDouble();
                        sc.nextLine();

                        Investimento simulacao = new Investimento(
                                valorInv,
                                "Simulacao de investimento",
                                "Investimento",
                                tipoInv,
                                taxa
                        );

                        simulacao.simularAplicacao();
                        simulacao.calcularRendimentos();
                        break;

                    case 6:
                        System.out.println("\nFazendo logout... Ate a proxima!");
                        usuarioAtivo = null;
                        contaAtiva = null;
                        cartaoAtivo = null;
                        break;

                    default:
                        System.out.println("\nOpcao invalida! Tente novamente.");
                }
            }
        } while (true);

        sc.close();
    }
}