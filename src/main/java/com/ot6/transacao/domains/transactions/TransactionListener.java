package com.ot6.transacao.domains.transactions;

import com.ot6.transacao.domains.cards.Card;
import com.ot6.transacao.domains.cards.CardRepository;
import com.ot6.transacao.domains.cards.dtos.CardMessage;
import com.ot6.transacao.domains.establishments.Establishment;
import com.ot6.transacao.domains.establishments.EstablishmentRepository;
import com.ot6.transacao.domains.establishments.dtos.EstablishmentMessage;
import com.ot6.transacao.domains.transactions.dtos.TransactionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionListener {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    EstablishmentRepository establishmentRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listen(TransactionMessage transactionMessage) {
        System.out.println("---------------------------");
        System.out.println(transactionMessage.toString());


        EstablishmentMessage establishmentMessage = transactionMessage.getEstabelecimento();
        Optional<Establishment> possibleEstablishment =
                establishmentRepository.findByNameAndCityAndAddress(
                        establishmentMessage.getNome(),
                        establishmentMessage.getCidade(),
                        establishmentMessage.getEndereco()
                );

        Establishment establishment;

        if (possibleEstablishment.isPresent()) {
            establishment = possibleEstablishment.get();
        } else {
            establishment = establishmentMessage.toEntity();
            establishmentRepository.save(establishment);
        }

        CardMessage cardMessage = transactionMessage.getCartao();
        Optional<Card> possibleCard = cardRepository.findById(cardMessage.getId());

        Card card;

        if (possibleCard.isPresent()) {
            card = possibleCard.get();
        } else {
            card = cardMessage.toEntity();
            cardRepository.save(card);
        }

        Transaction transaction = transactionMessage.toEntity(establishment, card);
        transactionRepository.save(transaction);
    }
}
