package Programa;

import Utilitarios.Utils;

public class Conta {

    private static int counterAccount = 1;

    private int numConta;
    private Usuario usuario;
    private Double saldo = 0.0;

    //CONSTRUCTOR
    public Conta(Usuario usuario) {
        this.numConta = counterAccount;
        this.usuario = usuario;
        counterAccount++;
    }

    //GETTERS AND SETTERS
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    //TO STRING
    @Override
    public String toString() {
        return "\nNúmero da Conta: " + this.getNumConta() +
                "\nNome: " + this.usuario.getNome() +
                "\nCPF: " + this.usuario.getCPF() +
                "\nE-mail: " + this.usuario.getEmail() +
                "\nSaldo da conta: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    //MÉTODO DE DEPOSITAR
    public void depositar(Double valor){
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito realizado com sucesso! ");
        } else {
            System.out.println("Depósito não realizado :(, valor diferente do esperado. ");
        }
    }

    //MÉTODO DE SACAR
    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso! ");
        } else {
            System.out.println("Saque não realizado :(, saldo insuficiente. ");
        }
    }

    //MÉTODO DE TRANSFERIR
    public void transferir(Conta conta, Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            conta.setSaldo(conta.getSaldo() + valor);
            System.out.println("Transferência realizada com sucesso! ");
        }else {
            System.out.println("Transferência não foi realizada com êxito :(, saldo insuficiente. ");
        }
    }
}
