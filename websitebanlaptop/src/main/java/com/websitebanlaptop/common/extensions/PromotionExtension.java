package com.websitebanlaptop.common.extensions;

public class PromotionExtension {
	public static String generateRandomCode() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"; 
		// create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(10); 
        
		for (int i = 0; i < 10; i++) { 
			  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString();
	}
}
