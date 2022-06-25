package com.ad.springbootreact;

import com.ad.springbootreact.domain.Card;
import com.ad.springbootreact.repository.CardRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Locale;

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
            cardRepository.save(new Card(
                    faker.name().fullName(),
                    faker.finance().creditCard(),
                    BigDecimal.valueOf(faker.number().randomDouble(2, 0, 3000)),
                    BigDecimal.valueOf(faker.number().randomDouble(0, 4000, 5000))));
        }
    }
}