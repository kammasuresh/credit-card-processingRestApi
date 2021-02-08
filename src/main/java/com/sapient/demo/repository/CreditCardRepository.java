package com.sapient.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.demo.model.CreditCard;

public interface CreditCardRepository  extends  JpaRepository<CreditCard,Long>{

}
