package repositories;

import model.Funcionario;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class FuncionarioRepositorio implements IRepositorio<Funcionario> {
    
    private ArrayList<Funcionario> funcionarios;

    public FuncionarioRepositorio() {
        this.funcionarios = new ArrayList<>();
    }

    public FuncionarioRepositorio(ArrayList<Funcionario> funcionariosExistentes) {
        this.funcionarios = funcionariosExistentes;
    }

    @Override
    public void adicionar(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    @Override
    public void remover(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    @Override
    public void alterar(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == funcionario.getId()) {
                funcionarios.set(i, funcionario);
                return;
            }
        }
    }

    @Override
    public ArrayList<Funcionario> listar() {
        return new ArrayList<>(funcionarios);
    }

    @Override
    public Funcionario buscarPorId(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;
            }
        }
        return null;
    }

    public ArrayList<Funcionario> listarPorDepartamento(String departamento) {
        ArrayList<Funcionario> funcionariosDepto = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getDepartamento() != null && 
                funcionario.getDepartamento().equals(departamento)) {
                funcionariosDepto.add(funcionario);
            }
        }
        return funcionariosDepto;
    }

    public int tamanho() {
        return funcionarios.size();
    }
}
