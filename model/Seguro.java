package model;

import java.time.LocalDate;

public class Seguro {

    private String codigo;
    private String tipo;
    private Carro carro;
    private Cliente beneficiario;
    private double valor;
    private LocalDate inicio;
    private LocalDate termino;
    private String status;

    public Seguro() {
    }

    public Seguro(String codigo, String tipo, Carro carro) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.carro = carro;
        this.status = "Ativo";
    }

    public Seguro(String codigo, String tipo, Carro carro, Cliente beneficiario, double valor, LocalDate inicio, LocalDate termino) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.beneficiario = beneficiario;
        this.carro = carro;
        this.valor = valor;
        this.inicio = inicio;
        this.termino = termino;
        this.status = "Ativo";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Cliente beneficiario) {
        this.beneficiario = beneficiario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getTermino() {
        return termino;
    }

    public void setTermino(LocalDate termino) {
        this.termino = termino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seguro: " + codigo + " | Tipo: " + tipo + " | Status: " + status + " | Valor: R$ " + valor;
    }
}