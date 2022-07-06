package com.company.validator;


import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    private String startWith;

    @Override
    public void initialize(Phone constraintAnnotation) {
        startWith = constraintAnnotation.startWith();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !StringUtils.isEmpty(value)
                && value.startsWith(startWith);
    }
}
