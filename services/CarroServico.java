package services;

import model.Carro;
import repositories.CarroRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class CarroServico implements IServico<Carro> {
    
    private CarroRepositorio repositorio;

    public CarroServico() {
        this.repositorio = new CarroRepositorio();
    }

    public CarroServico(CarroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Carro carro) {
        if (validar(carro)) {
            repositorio.adicionar(carro);
        }
    }

    @Override
    public void remover(Carro carro) {
        repositorio.remover(carro);
    }

    @Override
    public void alterar(Carro carro) {
        if (validar(carro)) {
            repositorio.alterar(carro);
        }
    }

    @Override
    public ArrayList<Carro> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Carro carro) {
        if (carro.getModelo() == null || carro.getModelo().trim().isEmpty()) {
            return false;
        }
        if (carro.getPlaca() == null || carro.getPlaca().trim().isEmpty()) {
            return false;
        }
        if (carro.getValorDiaria() <= 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Carro> listarDisponiveis() {
        return repositorio.listarDisponiveis();
    }

    public Carro buscarPorPlaca(String placa) {
        return repositorio.buscarPorPlaca(placa);
    }

    public Carro buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public int totalCarros() {
        return repositorio.tamanho();
    }

    public int totalCarrosDisponiveis() {
        return repositorio.listarDisponiveis().size();
    }
}
