package com.springmvc.lc.validater;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.lc.dto.UserSignupDto;

@Component
public class UserNameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserSignupDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		// to check the field name is empty or not
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty");

		// user name must contain a '_'
		String userName = ((UserSignupDto) target).getUserName();

		if (!userName.contains("_")) {
			errors.rejectValue("userName", "userName.valid");
		}
		if (!userName.contains("1") && !userName.contains("2") && !userName.contains("3") && !userName.contains("4")
				&& !userName.contains("5") && !userName.contains("6") && !userName.contains("7")
				&& !userName.contains("8") && !userName.contains("9") && !userName.contains("0")) {
			errors.rejectValue("userName", "userName.valid.number");
		}
//		if (!userName.startsWith("a") && !userName.startsWith("b")) {
//			errors.rejectValue("userName", "userName.valid.formatt", "username must start with alphabet");
//		}
	}

}
