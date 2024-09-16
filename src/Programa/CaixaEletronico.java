package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class CaixaEletronico {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes(){
        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|     Opção 1 - Criar conta                |");
        System.out.println("|     Opção 2 - Depositar                  |");
        System.out.println("|     Opção 3 - Sacar                      |");
        System.out.println("|     Opção 4 - Transferir                 |");
        System.out.println("|     Opção 5 - Listar                     |");
        System.out.println("|     Opção 6 - Informação da conta        |");
        System.out.println("|     Opção 7 - Sair                       |");

        int operacao = scanner.nextInt();

        switch (operacao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                mostraConta();
                break;
            case 7:
                System.out.println("Operações finalizadas com sucesso!\n" +
                                   "Obrigado e volte sempre!");
                System.exit(0);

            default:
                System.out.println("Opção inválida!");
                operacoes();
                break;
        }
    }

    //MÉTODO PARA CRIAÇÃO DE CONTA DO USUÁRIO
    public static void criarConta(){

        System.out.println("\nNome: ");
        String nome = scanner.next();

        System.out.println("\nCPF: ");
        String cpf = scanner.next();

        System.out.println("\nE-mail: ");
        String email = scanner.next();

        Usuario usuario = new Usuario(nome, cpf, email);
        Conta conta = new Conta(usuario);

        contasBancarias.add(conta);

        System.out.println("Conta cadastrada com sucesso!");
        operacoes();
    }

    //MÉTODO PARA REALIZAR O DEPÓSITO
    public static void depositar(){
        System.out.println("Informe o número da conta para o depósito: ");
        int numConta = scanner.nextInt();

        Conta conta = encontrarConta(numConta);

        if (conta != null){
            System.out.println("Qual o valor do depósito?");
            Double valDeposito = scanner.nextDouble();
            conta.depositar(valDeposito);
        } else {
            System.out.println("Conta não foi encontrada :(");
        }
        operacoes();
    }

    public static void sacar(){
        System.out.println("Informe o número da conta para o saque: ");
        int numConta = scanner.nextInt();

        Conta conta = encontrarConta(numConta);

        if (conta != null){
            System.out.println("Qual o valor do saque?");
            Double valSaque = scanner.nextDouble();
            conta.sacar(valSaque);
        } else {
            System.out.println("Conta não foi encontrada :(");
        }
        operacoes();
    }

    public static void transferir(){
        System.out.println("Informe o número da conta do remetente: ");
        int numContaRemetente = scanner.nextInt();

        Conta contaRemetente = encontrarConta(numContaRemetente);

        if(contaRemetente != null){
            System.out.println("Informe o número da conta do destinátario: ");
            int numContaDestinatario = scanner.nextInt();

            Conta contaDestinatario = encontrarConta(numContaDestinatario);
            if (contaDestinatario != null){
                System.out.println("Informe o valor da transfêrencia: ");
                Double valTransferencia = scanner.nextDouble();

                contaRemetente.transferir(contaDestinatario, valTransferencia);
            }else {
                System.out.println("Conta não foi encontrada!");
            }
        } else {
            System.out.println("Conta não foi encontrada!");
        }
        operacoes();
    }

    public static void listar(){
        if(!contasBancarias.isEmpty()){
            for (Conta conta: contasBancarias){
                System.out.println(conta);
            }
        }else {
            System.out.println("Não há contas no sistema!");
        }
        operacoes();
    }

    //MÉTODO QUE MOSTRA A CONTA DO USUARIO
    private static void mostraConta(){
        System.out.println("Informe o número da conta do destinátario: ");
        int numConta = scanner.nextInt();

        Conta conta = encontrarConta(numConta);
        if (conta != null){
            System.out.println(conta);
        }else {
            System.out.println("Conta não foi encontrada :(");
        }
        operacoes();
    }

    /* MÉTODO QUE VERIFICA SE A CONTA É EXISTENTE OU NÃO, RETORNANDO O NÚMERO DA CONTA CASO SEJA ENCONTRADO,
       CASO CONTRÁRIO RETORNA UM VALOR NULL */
    private static Conta encontrarConta(int numeroConta){
        Conta conta = null;

        if (!contasBancarias.isEmpty()){
            for(Conta c : contasBancarias) {
                if (c.getNumConta() == numeroConta){
                    conta = c;
                } else {
                    System.out.println("Conta não encontrada!");
                }
            }
        }
        return conta;
    }
}
