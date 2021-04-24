package br.pucpr.ed.arvore;

import java.util.Objects;

public class Pessoa implements Comparable {
    private Long cpf;
    private String nome;

    public Pessoa(Long cpf) {
        this.cpf = cpf;
    }

    public Pessoa(Long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
            "cpf=" + cpf +
            ", nome='" + nome + '\'' +
            '}';
    }

    @Override
    public int compareTo(Object o) {
        Pessoa pessoa2 = (Pessoa) o;
        return this.cpf.compareTo(pessoa2.getCpf());
    }
}
