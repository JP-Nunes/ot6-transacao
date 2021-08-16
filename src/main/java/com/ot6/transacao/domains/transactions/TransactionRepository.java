package com.ot6.transacao.domains.transactions;

import com.ot6.transacao.domains.cards.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, String> {

    Page<Transaction> findByCard(Card card, Pageable pagination);
}
