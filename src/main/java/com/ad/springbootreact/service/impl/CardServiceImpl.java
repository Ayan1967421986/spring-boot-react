package com.ad.springbootreact.service.impl;

import com.ad.springbootreact.exception.RecordNotFoundException;
import com.ad.springbootreact.mapper.CardMapper;
import com.ad.springbootreact.model.domain.CardBO;
import com.ad.springbootreact.model.entity.CardEntity;
import com.ad.springbootreact.repository.CardRepository;
import com.ad.springbootreact.service.CardService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    @NonNull
    private final CardRepository cardRepository;
    @NonNull
    private final CardMapper cardMapper;

    /**
     * Fetch All Cards from Database
     *
     * @return List of All Cards
     */
    @Override
    public List<CardBO> findAll() {
        List<CardEntity> cardEntities = cardRepository.findAll();
        if (!cardEntities.isEmpty()) {
            return cardMapper.toCardBOs(cardEntities);
        }
        return Collections.emptyList();
    }

    /**
     * Fetch a single Card by ID from Database
     *
     * @param id the Database Sequence ID for a Card
     * @return Card if exists for the given ID
     */
    @Override
    public CardBO findById(Long id) {
        Optional<CardEntity> cardEntityOptional = cardRepository.findById(id);
        if (cardEntityOptional.isPresent()) {
            return cardMapper.toCardBO(cardEntityOptional.get());
        } else {
            throw new RecordNotFoundException();
        }
    }

    /**
     * Persists a New Card to Database
     *
     * @param cardBO the new Card to be persisted
     * @return the saved Card from the DB
     */
    @Override
    public CardBO save(CardBO cardBO) {
        // New card created with £0 balance
        cardBO.setBalance(BigDecimal.ZERO);
        return cardMapper.toCardBO(cardRepository.save(cardMapper.toCardEntity(cardBO)));
    }

    /**
     * Updates an Existing Card to Database
     *
     * @param cardBO the updated Card to be persisted
     * @return the updated Card from the DB
     */
    @Override
    public CardBO update(CardBO cardBO) {
        CardBO existingCard = this.findById(cardBO.getId());
        existingCard.setCardHolderName(cardBO.getCardHolderName());
        existingCard.setCardNumber(cardBO.getCardNumber());
        existingCard.setCardLimit(cardBO.getCardLimit());

        return cardMapper.toCardBO(cardRepository.save(cardMapper.toCardEntity(existingCard)));
    }

    /**
     * Delete an Existing Card from Database
     *
     * @param id the Card ID to be removed
     * @return void
     */
    @Override
    public void delete(Long id) {
        // Nothing to be returned post Card Delete
        cardRepository.deleteById(id);
    }
}
