package repositories;

import model.Aluguel;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class AluguelRepositorio implements IRepositorio<Aluguel> {
    
    private ArrayList<Aluguel> alugueis;

    public AluguelRepositorio() {
        this.alugueis = new ArrayList<>();
    }

    public AluguelRepositorio(ArrayList<Aluguel> aluguelsExistentes) {
        this.alugueis = aluguelsExistentes;
    }

    @Override
    public void adicionar(Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    @Override
    public void remover(Aluguel aluguel) {
        alugueis.remove(aluguel);
    }

    @Override
    public void alterar(Aluguel aluguel) {
        for (int i = 0; i < alugueis.size(); i++) {
            if (alugueis.get(i).getId() == aluguel.getId()) {
                alugueis.set(i, aluguel);
                return;
            }
        }
    }

    @Override
    public ArrayList<Aluguel> listar() {
        return new ArrayList<>(alugueis);
    }

    @Override
    public Aluguel buscarPorId(int id) {
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getId() == id) {
                return aluguel;
            }
        }
        return null;
    }

    public ArrayList<Aluguel> listarConfirmados() {
        ArrayList<Aluguel> confirmados = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.isConfirmado()) {
                confirmados.add(aluguel);
            }
        }
        return confirmados;
    }

    public ArrayList<Aluguel> listarPorCliente(int clienteId) {
        ArrayList<Aluguel> alugueisPorCliente = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getCliente() != null && aluguel.getCliente().getId() == clienteId) {
                alugueisPorCliente.add(aluguel);
            }
        }
        return alugueisPorCliente;
    }

    public int tamanho() {
        return alugueis.size();
    }
}
