package model;

import java.time.LocalDate;

public class Pagamento {

    private String tipo;
    private double valor;
    private LocalDate dataPagamento;
    private String status;

    public Pagamento() {
    }

    public Pagamento(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataPagamento = LocalDate.now();
        this.status = "Pendente";
    }

    public Pagamento(String tipo, double valor, LocalDate dataPagamento, String status) {
        this.tipo = tipo;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void processarPagamento() {
        status = "Pago";
        System.out.println("Pagamento de R$ " + valor + " processado via " + tipo);
    }

    public void estornarPagamento() {
        status = "Cancelado";
        System.out.println("Pagamento estornado.");
    }

    public void gerarRecibo() {
        System.out.println("Recibo: Tipo " + tipo + ", Valor R$ " + valor + ", Status: " + status);
    }

    @Override
    public String toString() {
        return "Pagamento: " + tipo + " | Valor: R$ " + valor + " | Status: " + status;
    }
}