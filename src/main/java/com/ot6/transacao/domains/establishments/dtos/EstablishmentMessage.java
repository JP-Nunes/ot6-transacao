package com.ot6.transacao.domains.establishments.dtos;

import com.ot6.transacao.domains.establishments.Establishment;

public class EstablishmentMessage {

    private String nome;
    private String cidade;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "EstablishmentMessage{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    public Establishment toEntity() {
        return new Establishment(this.nome, this.cidade, this.endereco);
    }
}
