package model;

public class Funcionario {

    private String nome;
    private String cpf;
    private String cargo;
    private String departamento;
    private String telefone;

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo) {
        this.nome = nome;
        this.cargo = cargo;
    }

    public Funcionario(String nome, String cpf, String cargo, String departamento, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.departamento = departamento;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório gerado pelo funcionário " + nome);
    }

    @Override
    public String toString() {
        return "Funcionario: " + nome + " | Cargo: " + cargo + " | Departamento: " + departamento;
    }
}