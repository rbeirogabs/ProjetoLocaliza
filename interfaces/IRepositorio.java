package interfaces;

import java.util.ArrayList;

public interface IRepositorio<T> {
    void adicionar(T entidade);
    void remover(T entidade);
    void alterar(T entidade);
    ArrayList<T> listar();
    T buscarPorId(int id);
}
