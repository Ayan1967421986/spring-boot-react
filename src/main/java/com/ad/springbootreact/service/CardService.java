package com.ad.springbootreact.service;

import com.ad.springbootreact.model.domain.CardBO;

import java.util.List;

public interface CardService {
    // TODO: 27/06/2022 A Generic Card Service with Type [Credit, Debit etc.] would be a
    // better approach for supporting multiple Card APIs with virtual Service layer

    /**
     * Fetch All Cards from Database
     *
     * @return List of All Cards
     */
    List<CardBO> findAll();

    /**
     * Fetch a single Card by ID from Database
     *
     * @param id the Database Sequence ID for a Card
     * @return Card if exists for the given ID
     */
    CardBO findById(Long id);

    /**
     * Persists a New Card to Database
     *
     * @param cardBO the new Card to be persisted
     * @return the saved Card from the DB
     */
    CardBO save(CardBO cardBO);

    /**
     * Updates an Existing Card to Database
     *
     * @param cardBO the updated Card to be persisted
     * @return the updated Card from the DB
     */
    CardBO update(CardBO cardBO);

    /**
     * Delete an Existing Card from Database
     *
     * @param id the Card ID to be removed
     * @return void
     */
    void delete(Long id);
}
