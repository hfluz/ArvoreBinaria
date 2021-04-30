package br.pucpr.ed.arvore;

public class ArvoreBinaria<T extends Comparable> {

    private Node<T> raiz;

    public ArvoreBinaria() {

    }

    public ArvoreBinaria(T dadosRaiz) {
        if (dadosRaiz == null) {
            throw new IllegalArgumentException("A raiz não pode nula!");
        }
        raiz = new Node<>(dadosRaiz);
    }

    public void adicionar(T dados) {
        Node<T> node = new Node<>(dados);
        raiz = adicionarRecursivamente(raiz, node);
    }

    private Node<T> adicionarRecursivamente(Node<T> noAtual, Node<T> novoNo) {
        if (noAtual == null) {
            return novoNo;
        }
        int resultado = novoNo.dados.compareTo(noAtual.dados);
        if (resultado < 0) {
            noAtual.filhoEsquerdo = adicionarRecursivamente(noAtual.filhoEsquerdo, novoNo);
        } else {
            noAtual.filhoDireito = adicionarRecursivamente(noAtual.filhoDireito, novoNo);
        }
        return noAtual;
    }

    public T buscar(T dados) {
        Node<T> noEncontrado = buscarRecursivamente(raiz, dados);
        if (noEncontrado != null) {
            return noEncontrado.dados;
        } else {
            return null;
        }
    }

    private Node<T> buscarRecursivamente(Node<T> noAtual, T dados) {
        if (noAtual == null) {
            return null;
        }
        int resultado = dados.compareTo(noAtual.dados);
        if (resultado == 0) {
            return noAtual;
        } else if (resultado < 0) {
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

    private void percorrerEmOrdemRecursivamente(Node<T> noAtual) {
        if (noAtual == null) {
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

    public T buscarMenorElemento() {
        Node<T> menorElemento = buscarMenorElementoRecursivamente(raiz);
        if (menorElemento != null) {
            return menorElemento.dados;
        } else {
            return null;
        }
    }

    private Node<T> buscarMenorElementoRecursivamente(Node<T> noAtual) {
        if (noAtual == null) {
            return null;
        }
        if (noAtual.filhoEsquerdo == null) {
            return noAtual;
        }
        return buscarMenorElementoRecursivamente(noAtual.filhoEsquerdo);
    }

    public Integer calcularProfundidade() {
        if (raiz == null) {
            return null;
        }
        return Math.max(
            calcularProfundidadeRecursivamente(raiz.filhoEsquerdo, 0),
            calcularProfundidadeRecursivamente(raiz.filhoDireito, 0)
        );
    }

    private Integer calcularProfundidadeRecursivamente(Node<T> noAtual, Integer profundidadeAtual) {
        if (noAtual == null) {
            return profundidadeAtual;
        }
        Integer profundidadeEsquerda = calcularProfundidadeRecursivamente(noAtual.filhoEsquerdo,
            profundidadeAtual + 1);
        Integer profundidadeDireita = calcularProfundidadeRecursivamente(noAtual.filhoDireito,
            profundidadeAtual + 1);
        return Math.max(profundidadeEsquerda, profundidadeDireita);
    }

    public Node<T> getRaiz() {
        return raiz;
    }


    public void imprimirArvore(){
        imprimirArvore(5);
    }

    public void imprimirArvore(int espacamento) {
        System.out.println("╦");
        imprimirArvoreRecursivamente(raiz, 0, espacamento);
    }

    /**
     * Contribuição do @gabrielpastori1
     */
    public void imprimirArvoreRecursivamente(Node<T> noAtual, int profundidade, int espacamento) {
        System.out.print("║");
        for (int i = 0; i < profundidade - 1; i++) {
            System.out.print("│" + " ".repeat(espacamento));
        }
        if (profundidade != 0) {
            if (noAtual.filhoDireito == null && noAtual.filhoEsquerdo == null) {
                System.out.print("└");
            } else {
                System.out.print("├");
            }
            System.out.print("─".repeat(espacamento));
        }

        System.out.println(noAtual.dados);
        if (noAtual.filhoEsquerdo != null) {
            imprimirArvoreRecursivamente(noAtual.filhoEsquerdo, profundidade + 1, espacamento);
        }
        if (noAtual.filhoDireito != null) {
            imprimirArvoreRecursivamente(noAtual.filhoDireito, profundidade + 1, espacamento);
        }
    }
}

