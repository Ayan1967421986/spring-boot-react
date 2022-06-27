package com.ad.springbootreact.validation.annotation;

import com.ad.springbootreact.validation.CreditCardNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Custom Annotation supports Credit Card Number Validation using Luhn-10 Algorithm
 */
@Documented
@Constraint(validatedBy = CreditCardNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CreditCardNumberConstraint {
    String message() default "Invalid phone number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
