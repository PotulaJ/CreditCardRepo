package com.restservice.creditcard.service;

import org.springframework.stereotype.Component;


	public class CardValidationService {
		 private boolean valid;
		    private CardCompany cardType;
		    private String error;
		    private String cardNo;

		    public CardValidationService(String cardNo, String error) {
		        this.cardNo = cardNo;
		        this.error = error;
		    }
		    public CardValidationService(String cardNo, CardCompany cardType) {
		        this.cardNo = cardNo;
		        this.valid = true;
		        this.cardType = cardType;
		    }
		    public boolean isValid() {
		        return valid;
		    }
		    public CardCompany getCardType() {
		        return cardType;
		    }
		    public String getError() {
		        return error;
		    }
		    public String cardNo() {
		        return this.cardNo;
		    }
		    public String getMessage() {
		        return cardNo + "     " + ((valid) ? ("card type: " + this.cardType ): error) ;
		    }
		
		 /**
	     * Checks if the field is a valid credit card number.
	     * @param card The card number to validate.
	     * @return Whether the card number is valid.
	     */
		    
	    public static CardValidationService isValid(final String cardIn) {
	        String card = cardIn.replaceAll("[^0-9]+", ""); // remove all non-numerics
	        if ((card == null) || (card.length() < 13) || (card.length() > 19)) {
	            return new CardValidationService(card,"Invalid card no");
	        }

	        if (!luhnCheck(card)) {
	            return new CardValidationService(card,"Luhn check failed");
	        }

	        CardCompany cc = CardCompany.gleanCompany(card);
	        if (cc == null) return new CardValidationService(card,"Invalid company card");
	        
	        return new CardValidationService(card,cc);
	    }
	    
	    
	    
	    /**
	     * Checks for a valid credit card number.
	     * @param cardNumber Credit Card Number.
	     * @return Whether the card number passes the luhnCheck.
	     */
	    protected static boolean luhnCheck(String cardNumber) {
	        // number must be validated as 0..9 numeric first!!
	        int digits = cardNumber.length();
	        int oddOrEven = digits & 1;
	        long sum = 0;
	        for (int count = 0; count < digits; count++) {
	            int digit = 0;
	            try {
	                digit = Integer.parseInt(cardNumber.charAt(count) + "");
	            } catch(NumberFormatException e) {
	                return false;
	            }

	            if (((count & 1) ^ oddOrEven) == 0) { 
	                digit *= 2;
	                if (digit > 9) {
	                    digit -= 9;
	                }
	            }
	            sum += digit;
	        }

	        return (sum == 0) ? false : (sum % 10 == 0);
	    }
	    
	}


