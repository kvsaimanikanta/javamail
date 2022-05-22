package com.springmvc.lc.validater;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer>{
	
	
	
	private int min;
	private int max;
	
	@Override
	public void initialize(Age age) {
		
		this.min = age.min();
		this.max = age.max();
		
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(age == null) {
			return false;
		}else if(age < min || age > max) {
			return false;
		}
		
		return true;
	}

}
