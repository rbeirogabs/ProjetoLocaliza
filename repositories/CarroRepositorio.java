package repositories;

import model.Carro;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class CarroRepositorio implements IRepositorio<Carro> {
    
    private ArrayList<Carro> carros;

    public CarroRepositorio() {
        this.carros = new ArrayList<>();
    }

    public CarroRepositorio(ArrayList<Carro> carrosExistentes) {
        this.carros = carrosExistentes;
    }

    @Override
    public void adicionar(Carro carro) {
        carros.add(carro);
    }

    @Override
    public void remover(Carro carro) {
        carros.remove(carro);
    }

    @Override
    public void alterar(Carro carro) {
        for (int i = 0; i < carros.size(); i++) {
            if (carros.get(i).getId() == carro.getId()) {
                carros.set(i, carro);
                return;
            }
        }
    }

    @Override
    public ArrayList<Carro> listar() {
        return new ArrayList<>(carros);
    }

    @Override
    public Carro buscarPorId(int id) {
        for (Carro carro : carros) {
            if (carro.getId() == id) {
                return carro;
            }
        }
        return null;
    }

    public Carro buscarPorPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    public ArrayList<Carro> listarDisponiveis() {
        ArrayList<Carro> disponibles = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.isDisponivel()) {
                disponibles.add(carro);
            }
        }
        return disponibles;
    }

    public int tamanho() {
        return carros.size();
    }
}
