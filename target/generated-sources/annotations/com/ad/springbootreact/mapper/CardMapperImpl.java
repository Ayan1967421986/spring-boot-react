package com.ad.springbootreact.mapper;

import com.ad.springbootreact.model.domain.CardBO;
import com.ad.springbootreact.model.entity.CardEntity;
import com.ad.springbootreact.model.rest.Card;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-27T21:42:09+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
)
@Component
public class CardMapperImpl implements CardMapper {

    @Override
    public Card toCard(CardBO cardBO) {
        if ( cardBO == null ) {
            return null;
        }

        Long id = null;
        String cardHolderName = null;
        String cardNumber = null;
        BigDecimal cardLimit = null;
        BigDecimal balance = null;

        id = cardBO.getId();
        cardHolderName = cardBO.getCardHolderName();
        cardNumber = cardBO.getCardNumber();
        cardLimit = cardBO.getCardLimit();
        balance = cardBO.getBalance();

        Card card = new Card( id, cardHolderName, cardNumber, cardLimit, balance );

        return card;
    }

    @Override
    public List<Card> toCards(List<CardBO> cardBOs) {
        if ( cardBOs == null ) {
            return null;
        }

        List<Card> list = new ArrayList<Card>( cardBOs.size() );
        for ( CardBO cardBO : cardBOs ) {
            list.add( toCard( cardBO ) );
        }

        return list;
    }

    @Override
    public CardBO toCardBO(Card card) {
        if ( card == null ) {
            return null;
        }

        CardBO.CardBOBuilder cardBO = CardBO.builder();

        cardBO.cardHolderName( card.getCardHolderName() );
        cardBO.cardNumber( card.getCardNumber() );
        cardBO.balance( card.getBalance() );
        cardBO.cardLimit( card.getCardLimit() );

        return cardBO.build();
    }

    @Override
    public CardBO toCardBO(CardEntity cardEntity) {
        if ( cardEntity == null ) {
            return null;
        }

        CardBO.CardBOBuilder cardBO = CardBO.builder();

        cardBO.id( cardEntity.getId() );
        cardBO.cardHolderName( cardEntity.getCardHolderName() );
        cardBO.cardNumber( cardEntity.getCardNumber() );
        cardBO.balance( cardEntity.getBalance() );
        cardBO.cardLimit( cardEntity.getCardLimit() );

        return cardBO.build();
    }

    @Override
    public List<CardBO> toCardBOs(List<CardEntity> cardEntities) {
        if ( cardEntities == null ) {
            return null;
        }

        List<CardBO> list = new ArrayList<CardBO>( cardEntities.size() );
        for ( CardEntity cardEntity : cardEntities ) {
            list.add( toCardBO( cardEntity ) );
        }

        return list;
    }

    @Override
    public CardEntity toCardEntity(CardBO cardBO) {
        if ( cardBO == null ) {
            return null;
        }

        CardEntity.CardEntityBuilder cardEntity = CardEntity.builder();

        cardEntity.id( cardBO.getId() );
        cardEntity.cardHolderName( cardBO.getCardHolderName() );
        cardEntity.cardNumber( cardBO.getCardNumber() );
        cardEntity.balance( cardBO.getBalance() );
        cardEntity.cardLimit( cardBO.getCardLimit() );

        return cardEntity.build();
    }
}
