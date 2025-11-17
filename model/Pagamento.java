package model;

import java.time.LocalDate;

public class Pagamento extends EntidadeBase {

    private String tipo;
    private double valor;
    private LocalDate dataPagamento;
    private String status;

    public Pagamento() {
        super();
    }

    public Pagamento(String tipo, double valor) {
        super();
        this.tipo = tipo;
        this.valor = valor;
        this.dataPagamento = LocalDate.now();
        this.status = "Pendente";
    }

    public Pagamento(String tipo, double valor, LocalDate dataPagamento, String status) {
        super();
        this.tipo = tipo;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.status = status;
    }

    @Override
    public String obterDescricao() {
        return "Pagamento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                '}';
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

    public boolean isConfirmado() {
        return "Pago".equals(status);
    }

    @Override
    public String toString() {
        return "Pagamento: " + tipo + " | Valor: R$ " + valor + " | Status: " + status;
    }
}