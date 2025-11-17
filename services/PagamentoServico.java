package services;

import model.Pagamento;
import repositories.PagamentoRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class PagamentoServico implements IServico<Pagamento> {
    
    private PagamentoRepositorio repositorio;

    public PagamentoServico() {
        this.repositorio = new PagamentoRepositorio();
    }

    public PagamentoServico(PagamentoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Pagamento pagamento) {
        if (validar(pagamento)) {
            repositorio.adicionar(pagamento);
        }
    }

    @Override
    public void remover(Pagamento pagamento) {
        repositorio.remover(pagamento);
    }

    @Override
    public void alterar(Pagamento pagamento) {
        if (validar(pagamento)) {
            repositorio.alterar(pagamento);
        }
    }

    @Override
    public ArrayList<Pagamento> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Pagamento pagamento) {
        if (pagamento.getAluguel() == null) {
            return false;
        }
        if (pagamento.getValor() <= 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Pagamento> listarConfirmados() {
        return repositorio.listarConfirmados();
    }

    public Pagamento buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public int totalPagamentos() {
        return repositorio.tamanho();
    }

    public double obterReceitaTotal() {
        return repositorio.obterReceitaTotal();
    }

    public double obterReceitaPorcentagem(int percentual) {
        return (obterReceitaTotal() * percentual) / 100;
    }
}
