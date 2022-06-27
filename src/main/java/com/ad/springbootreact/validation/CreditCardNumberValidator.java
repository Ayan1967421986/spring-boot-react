package com.ad.springbootreact.validation;

import com.ad.springbootreact.validation.annotation.CreditCardNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Custom Validator supports Credit Card Number Validation using Luhn-10 Algorithm
 */
public class CreditCardNumberValidator implements
        ConstraintValidator<CreditCardNumberConstraint, String> {

    @Override
    public void initialize(CreditCardNumberConstraint creditCardNumber) {
        // Custom Validator registration
    }

    /**
     * Returns true if given Credit Card Number is Valid
     *
     * @param cardNumber provided Card Number
     * @param cxt        the ConstraintValidatorContext
     * @return true if Valid
     */
    @Override
    public boolean isValid(String cardNumber,
                           ConstraintValidatorContext cxt) {
        return checkLuhn10(cardNumber.replace("-", ""));
    }

    /**
     * Algorithm as referenced from <a href="https://www.geeksforgeeks.org/luhn-algorithm/">...</a>
     *
     * @param cardNumber
     * @return
     */
    private boolean checkLuhn10(String cardNumber) {
        int nDigits = cardNumber.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {

            int d = cardNumber.charAt(i) - '0';

            if (isSecond)
                d = d * 2;

            // We add two digits to handle
            // cases that make two digits
            // after doubling
            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

}
