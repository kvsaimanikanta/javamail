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
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	
	int min() default 18;
	
	int max() default 75;
	
	String message() default "{invalidAgeMessage}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
