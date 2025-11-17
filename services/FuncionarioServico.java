package services;

import model.Funcionario;
import repositories.FuncionarioRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class FuncionarioServico implements IServico<Funcionario> {
    
    private FuncionarioRepositorio repositorio;

    public FuncionarioServico() {
        this.repositorio = new FuncionarioRepositorio();
    }

    public FuncionarioServico(FuncionarioRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Funcionario funcionario) {
        if (validar(funcionario)) {
            repositorio.adicionar(funcionario);
        }
    }

    @Override
    public void remover(Funcionario funcionario) {
        repositorio.remover(funcionario);
    }

    @Override
    public void alterar(Funcionario funcionario) {
        if (validar(funcionario)) {
            repositorio.alterar(funcionario);
        }
    }

    @Override
    public ArrayList<Funcionario> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().trim().isEmpty()) {
            return false;
        }
        if (funcionario.getCargo() == null || funcionario.getCargo().trim().isEmpty()) {
            return false;
        }
        if (funcionario.getSalario() < 0) {
            return false;
        }
        return true;
    }

    public Funcionario buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }

    public Funcionario buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public ArrayList<Funcionario> listarPorDepartamento(String departamento) {
        return repositorio.listarPorDepartamento(departamento);
    }

    public int totalFuncionarios() {
        return repositorio.tamanho();
    }

    public double obterFolhaPagamento() {
        double total = 0;
        for (Funcionario funcionario : repositorio.listar()) {
            total += funcionario.getSalario();
        }
        return total;
    }
}
