package model;

import java.time.LocalDate;

public class Aluguel extends EntidadeBase {

    private Cliente cliente;
    private Carro carro;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private String local;
    private boolean confirmado;

    public Aluguel() {
        super();
        this.confirmado = false;
    }

    public Aluguel(Cliente cliente, Carro carro) {
        super();
        this.cliente = cliente;
        this.carro = carro;
        this.dataAluguel = LocalDate.now();
        this.local = "Não informado";
        this.confirmado = false;
    }

    public Aluguel(Cliente cliente, Carro carro, LocalDate dataAluguel, String local) {
        super();
        this.cliente = cliente;
        this.carro = carro;
        this.dataAluguel = dataAluguel;
        this.local = local;
        this.confirmado = false;
    }

    public Aluguel(int id, Cliente cliente, Carro carro, LocalDate dataAluguel, 
                   LocalDate dataDevolucao, String local, boolean confirmado) {
        super();
        this.id = id;
        this.cliente = cliente;
        this.carro = carro;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.local = local;
        this.confirmado = confirmado;
    }

    @Override
    public String obterDescricao() {
        return "Aluguel{" +
                "id=" + id +
                ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") +
                ", carro=" + (carro != null ? carro.getModelo() : "N/A") +
                ", confirmado=" + confirmado +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(LocalDate dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", cliente=" + (cliente != null ? cliente.getNome() : "N/A") +
                ", carro=" + (carro != null ? carro.getModelo() : "N/A") +
                ", dataAluguel=" + dataAluguel +
                ", dataDevolucao=" + dataDevolucao +
                ", local='" + local + '\'' +
                ", confirmado=" + confirmado +
                '}';
    }
}