package com.ot6.transacao.domains.cards.dtos;

public class CardListResponse {

    private final String id;
    private final String email;

    public CardListResponse(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
