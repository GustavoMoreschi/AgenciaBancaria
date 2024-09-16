package Programa;

public class Usuario {
    //VÁRIAVEIS
    private  static int counter = 1;

    private String nome;
    private String CPF;
    private String email;

    //CONSTRUCTOR
    public Usuario(String nome, String CPF, String email) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        counter++;
    }

    //GETTERS AND SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.getNome() +
                "\nCPF: " + this.getCPF() +
                "\nE-mail: " + this.getEmail();
    }

    public void depositar (){

    }
}
