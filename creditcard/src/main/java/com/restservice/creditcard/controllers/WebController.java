package com.restservice.creditcard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.restservice.creditcard.model.CreditCardNumber;
import com.restservice.creditcard.service.CardValidationService;


@Controller
public class WebController {
	
	   @GetMapping("creditcard")
	   public String getForm(Model model) {
		   model.addAttribute("creditCardNumber", new CreditCardNumber());
	      return "creditcardform";
	   }
	   
	   
	   @PostMapping("/creditcard")
		  public String getSubmit(@ModelAttribute CreditCardNumber creditCardNumber, Model model) {
		   System.out.println("inside getSubmit method ");
			  model.addAttribute("creditCardNumber", creditCardNumber);
			  CardValidationService result = CardValidationService.isValid(creditCardNumber.getCardNumber());
			  if(result.isValid()) {
				  creditCardNumber.setMessage("Valid  card   " + result.getMessage());
			  }else {
				  creditCardNumber.setMessage("Invalid card number");
			  }
			  model.addAttribute("creditCardNumber", creditCardNumber);
		      return "creditcardform";
		  }
		
	   
	
}

