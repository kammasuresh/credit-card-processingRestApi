package com.sapient.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.demo.exception.ResourceNotFoundException;
import com.sapient.demo.model.CreditCard;
import com.sapient.demo.repository.CreditCardRepository;

@Service
@Transactional
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Override
    public CreditCard createCreditCard(CreditCard cc) {
        return creditCardRepository.save(cc);
    }

    @Override
    public CreditCard updateCreditCard(long id, CreditCard uc) {
        Optional<CreditCard> updateCC = this.creditCardRepository.findById(uc.getId());
        if (updateCC.isPresent()) {
            CreditCard creditCardUpdate = updateCC.get();
            creditCardUpdate.setId(uc.getId());
            creditCardUpdate.setCardNumber(uc.getCardNumber());
            creditCardUpdate.setFullName(uc.getFullName());
            creditCardUpdate.setCardLimit(uc.getCardLimit());
            creditCardRepository.save(creditCardUpdate);
            return creditCardUpdate;
        } else {
            throw new ResourceNotFoundException("Record Not  found  with ID" + uc.getId());
        }
    }

    @Override
    public List<CreditCard> getCreditCardAll() {
        return this.creditCardRepository.findAll();
    }

    @Override
    public CreditCard getCreditCardById(long creditCardId) {
        Optional<CreditCard> updateCC = this.creditCardRepository.findById(creditCardId);
        if (updateCC.isPresent()) {
            return updateCC.get();
        } else {
            throw new ResourceNotFoundException("Record Not  found  with ID", +creditCardId);
        }
    }

    @Override
    public void deleteCreditCardById(long creditCardId) {
        Optional<CreditCard> updateCC = this.creditCardRepository.findById(creditCardId);
        if (updateCC.isPresent()) {
            this.creditCardRepository.delete(updateCC.get());
        } else {
            throw new ResourceNotFoundException("Record Not  found  with ID", +creditCardId);
        }

    }


}
