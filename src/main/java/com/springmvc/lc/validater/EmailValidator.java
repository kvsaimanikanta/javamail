package com.springmvc.lc.validater;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.lc.dto.UserSignupDto;

@Component
public class EmailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserSignupDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDto.email", "email.empty");
		
		String email = ((UserSignupDto)target).getCommunicationDto().getEmail();
		if(!email.endsWith("@gmail.com")) {
			errors.rejectValue("communicationDto.email", "email.validate");
		}
	}

}
