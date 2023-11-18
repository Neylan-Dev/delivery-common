package com.neylandev.delivery.domain.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephoneValidator implements ConstraintValidator<Telephone, String> {

    private final Pattern pattern = Pattern.compile("^[1-9]{2}(?:[2-8]|9[1-9])[0-9]{3}[0-9]{4}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || "".equals(value)) {
            return true;
        }

        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
