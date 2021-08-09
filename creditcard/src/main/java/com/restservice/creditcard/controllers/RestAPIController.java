package com.restservice.creditcard.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.creditcard.service.CardValidationService;

@RestController
public class RestAPIController {
	
		@GetMapping("creditcardcheck/{cardNumber}")
	    public CardValidationService getResult(@PathVariable("cardNumber") String cardNumber){
	    	
			CardValidationService result = CardValidationService.isValid(cardNumber);
			return result;
		}
	    	


}
