package com.ad.springbootreact;

import com.ad.springbootreact.model.entity.CardEntity;
import com.ad.springbootreact.repository.CardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Class supports Bootstrapping Stub Credit Cards to in-memory H2-DB
 */
@Component
public class BoostrapInitialCardData implements CommandLineRunner {

    private final CardRepository cardRepository;
    private final Faker faker = new Faker(Locale.getDefault());

    public BoostrapInitialCardData(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < 10; i++) {
            cardRepository.save(CardEntity.builder()
                    .cardHolderName(faker.name().fullName())
                    .cardNumber(faker.finance().creditCard())
                    .balance(BigDecimal.valueOf(faker.number().randomDouble(2, 0, 3000)))
                    .cardLimit(BigDecimal.valueOf(faker.number().randomDouble(0, 4000, 5000)))
                    .build());
        }
    }
}