package com.restservice.creditcard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.restservice.creditcard.service.CardValidationService;

@SpringBootTest
class CreditcardApplicationTests {

	CardValidationService cardValidationService;

	@Test
	@Order(1)
	public void testCardValidationService() {
		
		assertEquals(true,CardValidationService.isValid("4111111111111111").isValid());
		assertEquals(false,CardValidationService.isValid("4111111111111").isValid());
		assertEquals(true,CardValidationService.isValid("4012888888881881").isValid()); 
		assertEquals(true,CardValidationService.isValid("378282246310005").isValid()); 
		assertEquals(true,CardValidationService.isValid("6011111111111117").isValid()); 
		assertEquals(true,CardValidationService.isValid("5105105105105100").isValid()); 
		assertEquals(true,CardValidationService.isValid("4111111111111111").isValid()); 
		assertEquals(false,CardValidationService.isValid("5105 1051 0510 5106").isValid());
		assertEquals(false,CardValidationService.isValid("9111111111111111").isValid()); 
	}
	
}
