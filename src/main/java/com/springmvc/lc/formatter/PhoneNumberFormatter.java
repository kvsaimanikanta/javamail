package com.springmvc.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springmvc.lc.dto.Phone;

public class PhoneNumberFormatter implements Formatter<Phone>{

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return object.getCountryCode()+"-"+object.getNumber();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {

		// spilt the phone number
		String[] split = text.split("-");
		Phone phone = new Phone();

		int index = text.indexOf('-');
		//System.out.println(index);
		if (index == -1) {
			// set the default value for the country code and remaining is set to the number
			phone.setCountryCode("91");
			phone.setNumber(split[0]);
		} else if(text.startsWith("-")) {

			// set the country code and number
			phone.setCountryCode("91");
			phone.setNumber(split[1]);
		} else {

			// set the country code and number
			phone.setCountryCode(split[0]);
			phone.setNumber(split[1]);
		}

		return phone;
	}

}
