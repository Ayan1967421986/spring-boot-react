package com.ad.springbootreact.controller;

import com.ad.springbootreact.domain.Card;
import com.ad.springbootreact.repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/cards")
public class CardController {

    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        return cardRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createCard(@RequestBody Card card) throws URISyntaxException {
        Card savedCard = cardRepository.save(card);
        return ResponseEntity.created(new URI("/v1/cards/" + savedCard.getId())).body(savedCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCard(@PathVariable Long id, @RequestBody Card card) {
        Card currentCard = cardRepository.findById(id).orElseThrow(RuntimeException::new);
        currentCard.setCardHolderName(card.getCardHolderName());
        currentCard.setCardLimit(card.getCardLimit());

        currentCard = cardRepository.save(currentCard);

        return ResponseEntity.ok(currentCard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCard(@PathVariable Long id) {
        cardRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
