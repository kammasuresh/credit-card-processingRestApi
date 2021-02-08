package com.sapient.demo.controller;

import com.sapient.demo.model.CreditCard;
import com.sapient.demo.service.CreditCardService;
import com.sapient.demo.validators.CreditCardConstraint;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class CreditCardController {

    private final CreditCardService creditcardService;

    public CreditCardController(CreditCardService creditcardService) {
        this.creditcardService = creditcardService;
    }

    @GetMapping("/cards/credit-card")
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        List<CreditCard> allCreditCards = creditcardService.getCreditCardAll();
        return new ResponseEntity<List<CreditCard>>(allCreditCards, HttpStatus.OK);
    }

    @GetMapping("/cards/credit-card/{id}")
    public ResponseEntity<CreditCard> getAllCreditCards(@PathVariable long id) {
        CreditCard creditCardById = creditcardService.getCreditCardById(id);
        return new ResponseEntity<CreditCard>(creditCardById, HttpStatus.CREATED);
    }

    @PostMapping(value = "/cards/credit-card", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreditCard> createCreditCard(@CreditCardConstraint @RequestBody CreditCard creditcard) {
        CreditCard creditCard = creditcardService.createCreditCard(creditcard);
        return new ResponseEntity<CreditCard>(creditCard, HttpStatus.CREATED);
    }

    @PutMapping("/cards/credit-card/{id}")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable long id, @RequestBody CreditCard creditcard) {
        creditcard.setId(id);
        CreditCard creditCard = creditcardService.updateCreditCard(id, creditcard);
        return new ResponseEntity<CreditCard>(creditCard, HttpStatus.OK);
    }

}
