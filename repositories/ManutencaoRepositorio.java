package repositories;

import model.Manutencao;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class ManutencaoRepositorio implements IRepositorio<Manutencao> {
    
    private ArrayList<Manutencao> manutencoes;

    public ManutencaoRepositorio() {
        this.manutencoes = new ArrayList<>();
    }

    public ManutencaoRepositorio(ArrayList<Manutencao> manutencoeExistentes) {
        this.manutencoes = manutencoeExistentes;
    }

    @Override
    public void adicionar(Manutencao manutencao) {
        manutencoes.add(manutencao);
    }

    @Override
    public void remover(Manutencao manutencao) {
        manutencoes.remove(manutencao);
    }

    @Override
    public void alterar(Manutencao manutencao) {
        for (int i = 0; i < manutencoes.size(); i++) {
            if (manutencoes.get(i).getId() == manutencao.getId()) {
                manutencoes.set(i, manutencao);
                return;
            }
        }
    }

    @Override
    public ArrayList<Manutencao> listar() {
        return new ArrayList<>(manutencoes);
    }

    @Override
    public Manutencao buscarPorId(int id) {
        for (Manutencao manutencao : manutencoes) {
            if (manutencao.getId() == id) {
                return manutencao;
            }
        }
        return null;
    }

    public ArrayList<Manutencao> listarNaoConcluidas() {
        ArrayList<Manutencao> naoConcluidas = new ArrayList<>();
        for (Manutencao manutencao : manutencoes) {
            if (!manutencao.isConcluida()) {
                naoConcluidas.add(manutencao);
            }
        }
        return naoConcluidas;
    }

    public ArrayList<Manutencao> listarPorCarro(int carroId) {
        ArrayList<Manutencao> manutPorCarro = new ArrayList<>();
        for (Manutencao manutencao : manutencoes) {
            if (manutencao.getCarro() != null && manutencao.getCarro().getId() == carroId) {
                manutPorCarro.add(manutencao);
            }
        }
        return manutPorCarro;
    }

    public int tamanho() {
        return manutencoes.size();
    }
}
