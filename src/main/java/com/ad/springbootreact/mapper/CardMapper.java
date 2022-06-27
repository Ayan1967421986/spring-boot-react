package com.ad.springbootreact.mapper;

import com.ad.springbootreact.model.domain.CardBO;
import com.ad.springbootreact.model.entity.CardEntity;
import com.ad.springbootreact.model.rest.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card toCard(CardBO cardBO);

    List<Card> toCards(List<CardBO> cardBOs);

    @Mapping(target = "id", ignore = true)
    CardBO toCardBO(Card card);

    CardBO toCardBO(CardEntity cardEntity);

    List<CardBO> toCardBOs(List<CardEntity> cardEntities);

    CardEntity toCardEntity(CardBO cardBO);

}
