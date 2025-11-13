package model;

public class Carro {

    private String modelo;
    private String placa;
    private double valorDiaria;
    private String cor;
    private String tipoCombustivel;
    private boolean disponivel = true;

    public Carro() {
    }

    public Carro(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public Carro(String modelo, String placa, double valorDiaria, String cor, String tipoCombustivel) {
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void alugarCarro() {
        if (disponivel) {
            disponivel = false;
            System.out.println("Carro " + modelo + " alugado com sucesso.");
        } else {
            System.out.println("Carro " + modelo + " não está disponível.");
        }
    }

    public void checarDisponibilidade() {
        System.out.println("Carro " + modelo + (disponivel ? " está disponível." : " não está disponível."));
    }

    public void alterarModelo(String novoModelo) {
        this.modelo = novoModelo;
    }

    public void mostrarInfo() {
        System.out.println("Modelo: " + modelo + " | Placa: " + placa + " | Valor diária: R$ " + valorDiaria);
    }

    public void atualizarValorDiaria(double novoValor) {
        this.valorDiaria = novoValor;
    }

    @Override
    public String toString() {
        return "Carro: " + modelo + " | Placa: " + placa + " | Valor: R$ " + valorDiaria;
    }
}