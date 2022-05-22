package com.springmvc.lc.service;

import org.springframework.stereotype.Service;

@Service
public class LcAppCalulate {
	
	public final String LC_App_FORMULA = "FLAMES";
	
	public String calulate(String userName, String crushName) {
		
		int charCount = (userName+crushName).toCharArray().length;	
		
		int formilaCount = LC_App_FORMULA.toCharArray().length;
		
		int rem = charCount % formilaCount;
		
		char resultChar = LC_App_FORMULA.charAt(rem);
		
		String result = whatsBetweenUs(resultChar);
		
		return result;
	}

	private String whatsBetweenUs(char resultChar) {
		// TODO Auto-generated method stub
		
		String result = null;
		
		if(resultChar == 'F') {
			result = LcAppConstants.F_CHAR_MEANING;
		}else if(resultChar == 'L') {
			result = LcAppConstants.L_CHAR_MEANING;
		}else if(resultChar == 'A') {
			result = LcAppConstants.A_CHAR_MEANING;
		}else if(resultChar == 'M') {
			result = LcAppConstants.M_CHAR_MEANING;
		}else if(resultChar == 'E') {
			result = LcAppConstants.E_CHAR_MEANING;
		}else if(resultChar == 'S') {
			result = LcAppConstants.S_CHAR_MEANING;
		}
		
		return result;
	}

}
