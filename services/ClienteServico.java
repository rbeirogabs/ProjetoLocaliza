package services;

import model.Cliente;
import repositories.ClienteRepositorio;
import interfaces.IServico;
import java.util.ArrayList;

public class ClienteServico implements IServico<Cliente> {
    
    private ClienteRepositorio repositorio;

    public ClienteServico() {
        this.repositorio = new ClienteRepositorio();
    }

    public ClienteServico(ClienteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void cadastrar(Cliente cliente) {
        if (validar(cliente)) {
            repositorio.adicionar(cliente);
        }
    }

    @Override
    public void remover(Cliente cliente) {
        repositorio.remover(cliente);
    }

    @Override
    public void alterar(Cliente cliente) {
        if (validar(cliente)) {
            repositorio.alterar(cliente);
        }
    }

    @Override
    public ArrayList<Cliente> listar() {
        return repositorio.listar();
    }

    @Override
    public boolean validar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            return false;
        }
        if (cliente.getCpf() == null || cliente.getCpf().trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public Cliente buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }

    public Cliente buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    public int totalClientes() {
        return repositorio.tamanho();
    }
}
