package model;

public class Carro extends EntidadeBase {

    private String modelo;
    private String placa;
    private double valorDiaria;
    private String cor;
    private String tipoCombustivel;
    private boolean disponivel;

    public Carro() {
        super();
        this.disponivel = true;
    }

    public Carro(String modelo, String placa) {
        super();
        this.modelo = modelo;
        this.placa = placa;
        this.disponivel = true;
    }

    public Carro(String modelo, String placa, double valorDiaria, String cor, String tipoCombustivel) {
        super();
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.disponivel = true;
    }

    public Carro(int id, String modelo, String placa, double valorDiaria, String cor, 
                 String tipoCombustivel, boolean disponivel) {
        super();
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.disponivel = disponivel;
    }

    @Override
    public String obterDescricao() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", disponivel=" + disponivel +
                '}';
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

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", valorDiaria=" + valorDiaria +
                ", cor='" + cor + '\'' +
                ", tipoCombustivel='" + tipoCombustivel + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}