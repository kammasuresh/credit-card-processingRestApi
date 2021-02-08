package com.sapient.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.demo.model.CreditCard;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureWireMock(port = 0)
@ActiveProfiles("local")
public class CreditCardControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void shouldCreateCreditCard() throws Exception {
        CreditCard creditCard = getCreditCardRequest();

        mockMvc.perform(post("/cards/credit-card")
                .headers(requestHeaders())
                .content(objectMapper.writeValueAsString(creditCard)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldGetAllCreditCards() throws Exception {
        CreditCard creditCard = getCreditCardRequest();

        mockMvc.perform(get("/cards/credit-card")
                .headers(requestHeaders()))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldReturnBadRequestWhenInvalidCreditCardSent() throws Exception {
        CreditCard creditCard = getCreditCardRequest();
        creditCard.setCardNumber("12345678909765");

        mockMvc.perform(post("/cards/credit-card")
                .headers(requestHeaders())
                .content(objectMapper.writeValueAsString(creditCard)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    private CreditCard getCreditCardRequest(){
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("49927398716");
        creditCard.setFullName("Sapient");
        creditCard.setCardLimit(100000.00);
        return creditCard;
    }

    private HttpHeaders requestHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "application/json");
        return httpHeaders;
    }

}