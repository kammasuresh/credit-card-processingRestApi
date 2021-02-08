package com.sapient.demo.service;

import java.util.List;

import com.sapient.demo.model.CreditCard;

public interface CreditCardService {
	
	CreditCard createCreditCard(CreditCard cc);
	
	CreditCard updateCreditCard(long id, CreditCard uc);
	
	List<CreditCard> getCreditCardAll();
	
	CreditCard getCreditCardById(long creditCardId);

	void deleteCreditCardById(long creditCardId);
}
