package com.ot6.transacao.domains.establishments.dtos;

public class EstablishmentListResponse {

    private final String nome;
    private final String cidade;
    private final String endereco;

    public EstablishmentListResponse(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
