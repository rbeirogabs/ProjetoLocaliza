package model;

import java.time.LocalDate;

public class Manutencao extends EntidadeBase {

    private String codigo;
    private Carro carro;
    private String tipo;
    private LocalDate data;
    private String status;
    private Funcionario responsavel;
    private double custoManutencao;

    public Manutencao() {
        super();
    }

    public Manutencao(String codigo, Carro carro, String tipo) {
        super();
        this.codigo = codigo;
        this.carro = carro;
        this.tipo = tipo;
        this.data = LocalDate.now();
        this.status = "Agendada";
        this.custoManutencao = 0.0;
    }

    public Manutencao(String codigo, Carro carro, String tipo, LocalDate data, Funcionario responsavel) {
        super();
        this.codigo = codigo;
        this.carro = carro;
        this.tipo = tipo;
        this.data = data;
        this.responsavel = responsavel;
        this.status = "Agendada";
        this.custoManutencao = 0.0;
    }

    @Override
    public String obterDescricao() {
        return "Manutencao{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                '}';
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

    public double getCustoManutencao() {
        return custoManutencao;
    }

    public void setCustoManutencao(double custoManutencao) {
        this.custoManutencao = custoManutencao;
    }

    public boolean isConcluida() {
        return "Concluida".equals(status) || "Concluída".equals(status);
    }

    @Override
    public String toString() {
        return "Manutencao: " + codigo + " | Tipo: " + tipo + " | Status: " + status;
    }
}