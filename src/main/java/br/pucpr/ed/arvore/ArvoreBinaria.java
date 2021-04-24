package br.pucpr.ed.arvore;

public class ArvoreBinaria<T extends Comparable> {
    private Node<T> raiz;

    public ArvoreBinaria(){

    }

    public ArvoreBinaria(T dadosRaiz) {
        if(dadosRaiz == null){
            throw new IllegalArgumentException("A raiz não pode nula!");
        }
        raiz = new Node<>(dadosRaiz);
    }
    public void adicionar(T dados) {
        Node<T> node = new Node<>(dados);
        raiz = adicionarRecursivamente(raiz, node);
    }

    private Node<T> adicionarRecursivamente(Node<T> noAtual, Node<T> novoNo){
        if(noAtual == null){
            return novoNo;
        }
        int resultado = novoNo.dados.compareTo(noAtual.dados);
        if(resultado < 0){
            noAtual.filhoEsquerdo = adicionarRecursivamente(noAtual.filhoEsquerdo, novoNo);
        } else{
            noAtual.filhoDireito = adicionarRecursivamente(noAtual.filhoDireito, novoNo);
        }
        return noAtual;
    }

    public T buscar(T dados) {
        Node<T> noEncontrado = buscarRecursivamente(raiz, dados);
        if(noEncontrado != null){
            return noEncontrado.dados;
        } else{
            return null;
        }
    }

    private Node<T> buscarRecursivamente(Node<T> noAtual, T dados){
        if(noAtual == null){
            return null;
        }
        int resultado = dados.compareTo(noAtual.dados);
        if(resultado == 0){
            return noAtual;
        } else if(resultado < 0){
            return buscarRecursivamente(noAtual.filhoEsquerdo, dados);
        } else {
            return buscarRecursivamente(noAtual.filhoDireito, dados);
        }
    }

    public void excluir(T dados) {

    }
    public void percorrerEmOrdem() {
        percorrerEmOrdemRecursivamente(raiz);
    }

    private void percorrerEmOrdemRecursivamente(Node<T> noAtual){
        if(noAtual == null){
            return;
        }
        percorrerEmOrdemRecursivamente(noAtual.filhoEsquerdo);
        System.out.print(noAtual.dados + " -> ");
        percorrerEmOrdemRecursivamente(noAtual.filhoDireito);
    }

    public void percorrerPreOrdem() {

    }

    public void percorrerPosOrdem() {

    }

    public Node<T> getRaiz() {
        return raiz;
    }
}

