package repositories;

import model.Cliente;
import interfaces.IRepositorio;
import java.util.ArrayList;

public class ClienteRepositorio implements IRepositorio<Cliente> {
    
    private ArrayList<Cliente> clientes;

    public ClienteRepositorio() {
        this.clientes = new ArrayList<>();
    }

    public ClienteRepositorio(ArrayList<Cliente> clientesExistentes) {
        this.clientes = clientesExistentes;
    }

    @Override
    public void adicionar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }

    @Override
    public void alterar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                return;
            }
        }
    }

    @Override
    public ArrayList<Cliente> listar() {
        return new ArrayList<>(clientes);
    }

    @Override
    public Cliente buscarPorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public int tamanho() {
        return clientes.size();
    }
}
