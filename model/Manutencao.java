package model;

import java.time.LocalDate;

public class Manutencao {

    private String codigo;
    private Carro carro;
    private String tipo;
    private LocalDate data;
    private String status;
    private Funcionario responsavel;

    public Manutencao() {
    }

    public Manutencao(String codigo, Carro carro, String tipo) {
        this.codigo = codigo;
        this.carro = carro;
        this.tipo = tipo;
        this.data = LocalDate.now();
        this.status = "Agendada";
    }

    public Manutencao(String codigo, Carro carro, String tipo, LocalDate data, Funcionario responsavel) {
        this.codigo = codigo;
        this.carro = carro;
        this.tipo = tipo;
        this.data = data;
        this.responsavel = responsavel;
        this.status = "Agendada";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Manutencao: " + codigo + " | Tipo: " + tipo + " | Status: " + status;
    }
}