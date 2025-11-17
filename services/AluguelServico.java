package services;

import model.Aluguel;
import repositories.AluguelRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class AluguelServico implements IServico<Aluguel> {
    
    private AluguelRepositorio repositorio;

    public AluguelServico() {
        this.repositorio = new AluguelRepositorio();
    }

    public AluguelServico(AluguelRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Aluguel aluguel) {
        if (validar(aluguel)) {
            if (aluguel.getCarro() != null) {
                aluguel.getCarro().setDisponivel(false);
            }
            repositorio.adicionar(aluguel);
        }
    }

    @Override
    public void remover(Aluguel aluguel) {
        if (aluguel.getCarro() != null) {
            aluguel.getCarro().setDisponivel(true);
        }
        repositorio.remover(aluguel);
    }

    @Override
    public void alterar(Aluguel aluguel) {
        if (validar(aluguel)) {
            repositorio.alterar(aluguel);
        }
    }

    @Override
    public ArrayList<Aluguel> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Aluguel aluguel) {
        if (aluguel.getCliente() == null) {
            return false;
        }
        if (aluguel.getCarro() == null) {
            return false;
        }
        if (aluguel.getDataAluguel() == null) {
            return false;
        }
        return true;
    }

    public ArrayList<Aluguel> listarConfirmados() {
        return repositorio.listarConfirmados();
    }

    public ArrayList<Aluguel> listarPorCliente(int clienteId) {
        return repositorio.listarPorCliente(clienteId);
    }

    public Aluguel buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public int totalAlugueis() {
        return repositorio.tamanho();
    }

    public int totalAlugueisConfirmados() {
        return repositorio.listarConfirmados().size();
    }
}
