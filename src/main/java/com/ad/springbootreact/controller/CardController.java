package com.ad.springbootreact.controller;

import com.ad.springbootreact.exception.CardExceptionHandler;
import com.ad.springbootreact.mapper.CardMapper;
import com.ad.springbootreact.model.domain.CardBO;
import com.ad.springbootreact.model.rest.Card;
import com.ad.springbootreact.service.CardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Card Controller currently supports only Credit Card APIs
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cards")
public class CardController {

    @NonNull
    private final CardService cardService;
    @NonNull
    private final CardMapper cardMapper;
    @NonNull
    private final CardExceptionHandler exceptionHandler;

    @GetMapping
    public List<Card> getCards() {
        // TODO: 26/06/2022 Scope for implementing Paginated Response 
        return cardMapper.toCards(cardService.findAll());
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        // TODO: 26/06/2022 Path variable validation to be implemented
        return cardMapper.toCard(cardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> createCard(@RequestBody @Valid Card card, BindingResult result) throws URISyntaxException {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(exceptionHandler.handleValidationExceptions(result));
        }
        CardBO cardBO = cardService.save(cardMapper.toCardBO(card));
        // TODO: 26/06/2022 Spring Heteos response URL Advice
        return ResponseEntity.created(new URI("/v1/cards/" + cardBO.getId())).body(cardMapper.toCard(cardBO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @Valid Card card, BindingResult result) {
        CardBO updatedCardBO = cardService.update(cardMapper.toCardBO(card));
        return ResponseEntity.ok().body(cardMapper.toCard(updatedCardBO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable Long id) {
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
