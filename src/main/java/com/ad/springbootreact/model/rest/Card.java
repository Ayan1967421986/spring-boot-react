package com.ad.springbootreact.model.rest;

import com.ad.springbootreact.validation.annotation.CreditCardNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Value
@AllArgsConstructor
public class Card {

    Long id;

    @NotBlank(message = "cardHolderName is mandatory!!!")
    String cardHolderName;

    @NotBlank(message = "cardNumber is mandatory!!!")
    @Length(max = 19, message = "cardNumber must be less than 19 characters!!!")
    @Pattern(regexp = "^[0-9\\s\\-]+$", message = "cardNumber should contain only digits & dashes !!!")
    @CreditCardNumberConstraint(message = "cardNumber should be compatible with Luhn10!!!")
    String cardNumber;

    @NotNull(message = "cardLimit is mandatory!!!")
    BigDecimal cardLimit;

    BigDecimal balance;
}
