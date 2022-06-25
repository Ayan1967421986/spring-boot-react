//package com.ad.springbootreact.model.entity;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.math.BigDecimal;
//
//@Entity
//@Getter
//@Setter
//@Table(name = "card")
//public class CardEntity {
//    @Id
//    @GeneratedValue
//    Long id;
//
//    String cardHolderName;
//
//    String cardNumber;
//    BigDecimal balance;
//    BigDecimal cardLimit;
//
//    public CardEntity() {}
//    public CardEntity(String cardHolderName, String cardNumber, BigDecimal balance, BigDecimal cardLimit){
//        this.cardHolderName = cardHolderName;
//        this.cardNumber = cardNumber;
//        this.balance = balance;
//        this.cardLimit = cardLimit;
//    }
//    public CardEntity(Long id, String cardHolderName, String cardNumber, BigDecimal balance, BigDecimal cardLimit){
//        this.id = id;
//        this.cardHolderName = cardHolderName;
//        this.cardNumber = cardNumber;
//        this.balance = balance;
//        this.cardLimit = cardLimit;
//    }
//
//}
