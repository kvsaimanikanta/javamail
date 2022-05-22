package com.springmvc.lc.validater;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = PhoneValidator.class)
public @interface Phone {
	
	int min() default 14;
	
	int max() default 14;
	
	String message() default "check your number and number must be 10 degits";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
