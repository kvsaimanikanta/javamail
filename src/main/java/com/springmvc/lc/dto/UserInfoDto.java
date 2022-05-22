package com.springmvc.lc.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;


public class UserInfoDto {

	//@NotBlank(message = "* Your name con't be Null")
	@Size(min = 3, max = 10, message = "* Your name con't be blank and must be in 3 to 10 char only ")
	private String yourName;
	
	@Size(min = 2, max = 10, message = "* crush name con't be blank and must be in 2 to 10 char only")
	private String crushName;
	
	@AssertTrue(message = "* You have to accept the terms and condeations to use this app")
	private boolean termsAndCon;
	
	private String result;
	
	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermsAndCon() {
		return termsAndCon;
	}

	public void setTermsAndCon(boolean termsAndCon) {
		this.termsAndCon = termsAndCon;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
