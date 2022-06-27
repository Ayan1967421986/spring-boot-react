package com.ad.springbootreact.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "card")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CardEntity {
    @Id
    @GeneratedValue
    Long id;

    String cardHolderName;
    String cardNumber;
    BigDecimal balance;
    BigDecimal cardLimit;
}
