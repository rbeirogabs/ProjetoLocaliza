package model;

import java.time.LocalDate;

public class Aluguel {

    private Cliente cliente;
    private Carro carro;
    private LocalDate dataAluguel;
    private String local;
    private boolean confirmado;

    public Aluguel() {
    }

    public Aluguel(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
        this.dataAluguel = LocalDate.now();
        this.local = "Não informado";
    }

    public Aluguel(Cliente cliente, Carro carro, LocalDate dataAluguel, String local) {
        this.cliente = cliente;
        this.carro = carro;
        this.dataAluguel = dataAluguel;
        this.local = local;
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

    public void criarAluguel() {
        confirmado = true;
        System.out.println("Aluguel criado para " + cliente.getNome() + " com o carro " + carro.getModelo());
    }

    public void cancelarAluguel() {
        confirmado = false;
        System.out.println("Aluguel cancelado.");
    }

    public void mostrarTempoAluguel(int dias) {
        System.out.println("Tempo de aluguel: " + dias + " dias.");
    }

    @Override
    public String toString() {
        return "Aluguel: Cliente " + cliente.getNome() + " | Carro " + carro.getModelo() + " | Local: " + local;
    }
}