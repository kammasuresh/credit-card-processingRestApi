package com.sapient.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.CreditCardNumber;

@Entity
@Table(name = "CreditCard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "cardNumber")
    @CreditCardNumber(ignoreNonDigitCharacters = true)
    private String cardNumber;

    @Column(name = "cardLimit")
    private double cardLimit;

    public void setCardLimit(double cardLimit) {
        this.cardLimit = cardLimit;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


}
