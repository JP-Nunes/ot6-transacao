package com.ot6.transacao.domains.cards.dtos;

import com.ot6.transacao.domains.cards.Card;
import com.ot6.transacao.domains.cards.CardRepository;

public class CardMessage {

    private String id;
    private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CardMessage{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Card toEntity() {
        return new Card(this.id, this.email);
    }

    public boolean existsCardWithSameId(CardRepository cardRepository) {
        return cardRepository.findById(this.id).isPresent();
    }
}
