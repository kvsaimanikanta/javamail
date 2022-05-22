package com.springmvc.lc.validater;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, Phone>{
	
	@Override
	public void initialize(Phone phone) {
		
		phone.min();
		phone.max();
	}

	@Override
	public boolean isValid(Phone phone, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
//		if(phone ==  0,) {
//			
//		}
		
		return false;
	}

}
