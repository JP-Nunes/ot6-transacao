package com.ot6.transacao.domains.cards;

import com.ot6.transacao.domains.cards.dtos.CardListResponse;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cards")
public class Card {

    @NotBlank
    @Id
    @Column(nullable = false)
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String email;

    @Deprecated
    public Card() {}

    public Card(@NotBlank String id, @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

    public boolean exists(CardRepository cardRepository) {
        return cardRepository.findById(this.id).isPresent();
    }

    public CardListResponse toListResponse() {
        return new CardListResponse(this.id, this.email);
    }
}
