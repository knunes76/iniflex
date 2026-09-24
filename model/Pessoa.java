package model;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate DataNasc;

    public Pessoa(String nome, LocalDate dataNasc) {
        this.nome = nome;
        this.DataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNasc() {
        return DataNasc;
    }
}
