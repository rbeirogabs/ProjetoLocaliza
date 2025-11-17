package repositories;

import model.Seguro;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class SeguroRepositorio implements IRepositorio<Seguro> {
    
    private ArrayList<Seguro> seguros;

    public SeguroRepositorio() {
        this.seguros = new ArrayList<>();
    }

    public SeguroRepositorio(ArrayList<Seguro> segurosExistentes) {
        this.seguros = segurosExistentes;
    }

    @Override
    public void adicionar(Seguro seguro) {
        seguros.add(seguro);
    }

    @Override
    public void remover(Seguro seguro) {
        seguros.remove(seguro);
    }

    @Override
    public void alterar(Seguro seguro) {
        for (int i = 0; i < seguros.size(); i++) {
            if (seguros.get(i).getId() == seguro.getId()) {
                seguros.set(i, seguro);
                return;
            }
        }
    }

    @Override
    public ArrayList<Seguro> listar() {
        return new ArrayList<>(seguros);
    }

    @Override
    public Seguro buscarPorId(int id) {
        for (Seguro seguro : seguros) {
            if (seguro.getId() == id) {
                return seguro;
            }
        }
        return null;
    }

    public ArrayList<Seguro> listarAtivos() {
        ArrayList<Seguro> ativos = new ArrayList<>();
        for (Seguro seguro : seguros) {
            if (seguro.isAtivo()) {
                ativos.add(seguro);
            }
        }
        return ativos;
    }

    public ArrayList<Seguro> listarPorTipo(String tipoSeguro) {
        ArrayList<Seguro> segurosTipo = new ArrayList<>();
        for (Seguro seguro : seguros) {
            if (seguro.getTipoSeguro() != null && 
                seguro.getTipoSeguro().equals(tipoSeguro)) {
                segurosTipo.add(seguro);
            }
        }
        return segurosTipo;
    }

    public int tamanho() {
        return seguros.size();
    }
}
