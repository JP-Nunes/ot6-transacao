package com.ot6.transacao.domains.transactions.dtos;

import com.ot6.transacao.domains.cards.Card;
import com.ot6.transacao.domains.cards.dtos.CardListResponse;
import com.ot6.transacao.domains.cards.dtos.CardMessage;
import com.ot6.transacao.domains.establishments.Establishment;
import com.ot6.transacao.domains.establishments.dtos.EstablishmentListResponse;
import com.ot6.transacao.domains.establishments.dtos.EstablishmentMessage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionListResponse {

    private final String id;
    private final BigDecimal valor;
    private final EstablishmentListResponse estabelecimento;
    private final CardListResponse cartao;
    private final LocalDateTime efetivadaEm;

    public TransactionListResponse(
            String id,
            BigDecimal valor,
            Establishment estabelecimento,
            Card cartao,
            LocalDateTime efetivadaEm
    ) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento.toListResponse();
        this.cartao = cartao.toListResponse();
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstablishmentListResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CardListResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
