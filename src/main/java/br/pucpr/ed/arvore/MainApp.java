package br.pucpr.ed.arvore;

public class MainApp {

    public static void main(String[] args) {
        ArvoreBinaria<Integer> intTree = new ArvoreBinaria<>();
        intTree.adicionar(50);
        intTree.adicionar(34);
        intTree.adicionar(80);
        intTree.adicionar(29);
        intTree.adicionar(35);
        intTree.adicionar(98);
        intTree.adicionar(1);
        Integer elemento = intTree.buscar(29);
        System.out.println("Elemento buscado: " + elemento);
        System.out.println("Em ordem: ");
        intTree.percorrerEmOrdem();
        System.out.println("\nPré-ordem: ");
        intTree.percorrerPreOrdem();
        System.out.println("\nPós-ordem: ");
        intTree.percorrerPosOrdem();

        Pessoa pessoa = new Pessoa(12345678900L, "João das Neves");
        ArvoreBinaria<Pessoa> arvoreBinaria = new ArvoreBinaria<>(pessoa);
        arvoreBinaria.adicionar(new Pessoa(51276497059L, "Higor"));
        arvoreBinaria.adicionar(new Pessoa(51276497052L, "Humberto"));
        System.out.println(arvoreBinaria.buscar(new Pessoa(51276497059L)));
    }
}
