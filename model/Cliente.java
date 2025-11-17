package model;

public class Cliente extends EntidadeBase {

    private String nome;
    private String cnh;
    private String cpf;
    private String telefone;
    private String email;
    private String genero;

    public Cliente() {
        super();
    }

    public Cliente(String nome, String cpf) {
        super();
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cnh, String cpf, String telefone, String email, String genero) {
        super();
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.genero = genero;
    }

    public Cliente(int id, String nome, String cnh, String cpf, String telefone, String email, String genero) {
        super();
        this.id = id;
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.genero = genero;
    }

    @Override
    public String obterDescricao() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cnh='" + cnh + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", genero='" + genero + '\'' +
                '}';
    }
}