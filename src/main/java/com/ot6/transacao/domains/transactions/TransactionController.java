package com.ot6.transacao.domains.transactions;

import com.ot6.transacao.domains.cards.Card;
import com.ot6.transacao.domains.cards.CardRepository;
import com.ot6.transacao.domains.transactions.dtos.TransactionListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class TransactionController {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transactions/{cardId}")
    public ResponseEntity<?> listLastTenTransactions(@PathVariable String cardId) {
        Optional<Card> possibleCard = cardRepository.findById(cardId);

        if (possibleCard.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Sort sort = Sort.by(Sort.Direction.DESC, "effectedIn");
        Pageable pagination = PageRequest.of(0, 10, sort);

        Page<Transaction> transactions =
                transactionRepository.findByCard(possibleCard.get(), pagination);

        if (transactions.isEmpty()) {
            return ResponseEntity.ok("Nenhuma transação efetuada");
        }

        Page<TransactionListResponse> transactionListResponse =
                transactions.map(Transaction::toListResponse);

        return ResponseEntity.ok(transactionListResponse);
    }
}
