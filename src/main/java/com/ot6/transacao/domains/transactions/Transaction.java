package com.ot6.transacao.domains.transactions;

import com.ot6.transacao.domains.cards.Card;
import com.ot6.transacao.domains.establishments.Establishment;
import com.ot6.transacao.domains.transactions.dtos.TransactionListResponse;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @NotBlank
    @Id
    @Column(nullable = false)
    private String id;

    @NotNull
    @Column(nullable = false)
    private BigDecimal value;

    @NotNull
    @ManyToOne(optional = false)
    private Establishment establishment;

    @NotNull
    @ManyToOne(optional = false)
    private Card card;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime effectedIn;

    @Deprecated
    public Transaction() {}

    public Transaction(
            @NotBlank String id,
            @NotNull BigDecimal value,
            @NotNull Establishment establishment,
            @NotNull Card card,
            @NotNull LocalDateTime effectedIn
    ) {
        this.id = id;
        this.value = value;
        this.establishment = establishment;
        this.card = card;
        this.effectedIn = effectedIn;
    }

    public TransactionListResponse toListResponse() {
        return new TransactionListResponse(
                this.id, this.value, this.establishment, this.card, this.effectedIn
        );
    }
}
