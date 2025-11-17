package services;

import model.Seguro;
import repositories.SeguroRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class SeguroServico implements IServico<Seguro> {
    
    private SeguroRepositorio repositorio;

    public SeguroServico() {
        this.repositorio = new SeguroRepositorio();
    }

    public SeguroServico(SeguroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Seguro seguro) {
        if (validar(seguro)) {
            repositorio.adicionar(seguro);
        }
    }

    @Override
    public void remover(Seguro seguro) {
        repositorio.remover(seguro);
    }

    @Override
    public void alterar(Seguro seguro) {
        if (validar(seguro)) {
            repositorio.alterar(seguro);
        }
    }

    @Override
    public ArrayList<Seguro> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Seguro seguro) {
        if (seguro.getCarro() == null) {
            return false;
        }
        if (seguro.getTipoSeguro() == null || seguro.getTipoSeguro().trim().isEmpty()) {
            return false;
        }
        if (seguro.getValorSeguro() <= 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Seguro> listarAtivos() {
        return repositorio.listarAtivos();
    }

    public ArrayList<Seguro> listarPorTipo(String tipoSeguro) {
        return repositorio.listarPorTipo(tipoSeguro);
    }

    public Seguro buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public int totalSeguros() {
        return repositorio.tamanho();
    }

    public double obterValorTotalSegurosAtivos() {
        double total = 0;
        for (Seguro seguro : repositorio.listarAtivos()) {
            total += seguro.getValorSeguro();
        }
        return total;
    }
}
