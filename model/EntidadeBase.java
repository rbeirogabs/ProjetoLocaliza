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

    public abstract String obterDescricao();

    public void exibir() {
        System.out.println(obterDescricao());
    }

    public void exibir(String prefixo) {
        System.out.println(prefixo + " " + obterDescricao());
    }
}
