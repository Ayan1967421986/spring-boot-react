package com.ad.springbootreact.repository;

import com.ad.springbootreact.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Card Entity Specific CRUD repository
 */
public interface CardRepository extends JpaRepository<CardEntity, Long> {
}
