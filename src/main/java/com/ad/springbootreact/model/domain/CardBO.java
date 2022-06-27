package com.ad.springbootreact.model.domain;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CardBO {
    Long id;

    String cardHolderName;
    String cardNumber;
    BigDecimal balance;
    BigDecimal cardLimit;
}
