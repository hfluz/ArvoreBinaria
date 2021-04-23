package br.pucpr.ed.arvore;

public class Node {
    protected Integer dados;
    protected Node filhoEsquerdo;
    protected Node filhoDireito;

    public Node(Integer dados) {
        this.dados = dados;
    }

    public Integer getDados() {
        return dados;
    }

    public void setDados(Integer dados) {
        this.dados = dados;
    }

    public Node getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public void setFilhoEsquerdo(Node filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public Node getFilhoDireito() {
        return filhoDireito;
    }

    public void setFilhoDireito(Node filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

    @Override
    public String toString() {
        return "Node{" +
            "dados=" + dados +
            '}';
    }
}
