package model;

public class Cliente {

    private String nome;
    private String cnh;
    private String cpf;
    private String telefone;
    private String email;
    private String genero;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cnh, String cpf, String telefone, String email, String genero) {
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void fazerReserva() {
        System.out.println(nome + " fez uma reserva.");
    }

    public void cancelarReserva() {
        System.out.println(nome + " cancelou a reserva.");
    }

    public void avaliarCarro(Carro carro, String avaliacao) {
        System.out.println(nome + " avaliou o carro " + carro.getModelo() + ": " + avaliacao);
    }

    public void trocarCarro(Carro carroAntigo, Carro carroNovo) {
        System.out.println(nome + " trocou o carro " + carroAntigo.getModelo() + " para " + carroNovo.getModelo());
    }

    public void adicionarPreferencia(String preferencia) {
        System.out.println(nome + " adicionou preferência: " + preferencia);
    }

    @Override
    public String toString() {
        return "Cliente: " + nome + " | CPF: " + cpf + " | CNH: " + cnh;
    }
}