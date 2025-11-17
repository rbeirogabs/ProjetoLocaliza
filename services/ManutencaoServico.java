package services;

import model.Manutencao;
import repositories.ManutencaoRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class ManutencaoServico implements IServico<Manutencao> {
    
    private ManutencaoRepositorio repositorio;

    public ManutencaoServico() {
        this.repositorio = new ManutencaoRepositorio();
    }

    public ManutencaoServico(ManutencaoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Manutencao manutencao) {
        if (validar(manutencao)) {
            repositorio.adicionar(manutencao);
        }
    }

    @Override
    public void remover(Manutencao manutencao) {
        repositorio.remover(manutencao);
    }

    @Override
    public void alterar(Manutencao manutencao) {
        if (validar(manutencao)) {
            repositorio.alterar(manutencao);
        }
    }

    @Override
    public ArrayList<Manutencao> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Manutencao manutencao) {
        if (manutencao.getCarro() == null) {
            return false;
        }
        if (manutencao.getTipo() == null || manutencao.getTipo().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public ArrayList<Manutencao> listarNaoConcluidas() {
        return repositorio.listarNaoConcluidas();
    }

    public ArrayList<Manutencao> listarPorCarro(int carroId) {
        return repositorio.listarPorCarro(carroId);
    }

    public Manutencao buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public int totalManutencoes() {
        return repositorio.tamanho();
    }

    public double obterCustoTotalManutencoes() {
        double total = 0;
        for (Manutencao manutencao : repositorio.listar()) {
            total += manutencao.getCustoManutencao();
        }
        return total;
    }
}
