package repositories;

import model.Pagamento;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class PagamentoRepositorio implements IRepositorio<Pagamento> {
    
    private ArrayList<Pagamento> pagamentos;

    public PagamentoRepositorio() {
        this.pagamentos = new ArrayList<>();
    }

    public PagamentoRepositorio(ArrayList<Pagamento> pagamentosExistentes) {
        this.pagamentos = pagamentosExistentes;
    }

    @Override
    public void adicionar(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    @Override
    public void remover(Pagamento pagamento) {
        pagamentos.remove(pagamento);
    }

    @Override
    public void alterar(Pagamento pagamento) {
        for (int i = 0; i < pagamentos.size(); i++) {
            if (pagamentos.get(i).getId() == pagamento.getId()) {
                pagamentos.set(i, pagamento);
                return;
            }
        }
    }

    @Override
    public ArrayList<Pagamento> listar() {
        return new ArrayList<>(pagamentos);
    }

    @Override
    public Pagamento buscarPorId(int id) {
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getId() == id) {
                return pagamento;
            }
        }
        return null;
    }

    public ArrayList<Pagamento> listarConfirmados() {
        ArrayList<Pagamento> confirmados = new ArrayList<>();
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.isConfirmado()) {
                confirmados.add(pagamento);
            }
        }
        return confirmados;
    }

    public double obterReceitaTotal() {
        double total = 0;
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.isConfirmado()) {
                total += pagamento.getValor();
            }
        }
        return total;
    }

    public int tamanho() {
        return pagamentos.size();
    }
}
