package com.springmvc.lc.dto;

public class Phone {
	
	private String countryCode;
	private String number;
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "+"+getCountryCode()+"-"+getNumber();
	}

}
