package com.ot6.transacao.domains.transactions.dtos;

import com.ot6.transacao.domains.cards.Card;
import com.ot6.transacao.domains.cards.dtos.CardMessage;
import com.ot6.transacao.domains.establishments.Establishment;
import com.ot6.transacao.domains.establishments.dtos.EstablishmentMessage;
import com.ot6.transacao.domains.transactions.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionMessage {

    private String id;
    private BigDecimal valor;
    private EstablishmentMessage estabelecimento;
    private CardMessage cartao;
    private LocalDateTime efetivadaEm;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstablishmentMessage getEstabelecimento() {
        return estabelecimento;
    }

    public CardMessage getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "TransactionMessage{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public Transaction toEntity(Establishment estabelecimento, Card cartao) {
        return new Transaction(
                this.id,
                this.valor,
                estabelecimento,
                cartao,
                this.efetivadaEm
        );
    }
}
