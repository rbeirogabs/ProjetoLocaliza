package interfaces;

import java.util.ArrayList;

public interface IServico<T> {
    void cadastrar(T entidade);
    void remover(T entidade);
    void alterar(T entidade);
    ArrayList<T> listar();
    boolean validar(T entidade);
}
