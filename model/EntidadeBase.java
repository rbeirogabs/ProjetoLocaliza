package model;

public abstract class EntidadeBase {
    protected int id;
    protected static int contadorId = 1;

    public EntidadeBase() {
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Método abstrato que deve ser implementado pelas subclasses
    public abstract String obterDescricao();

    // Métodos concretos com sobrecarga
    public void exibir() {
        System.out.println(obterDescricao());
    }

    public void exibir(String prefixo) {
        System.out.println(prefixo + " " + obterDescricao());
    }
}
