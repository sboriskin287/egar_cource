package com.company.validator;

import com.company.domain.Domain;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BodyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Domain.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Domain domain = (Domain) target;
        String pn = domain.getPhoneNumber();
        if (StringUtils.isEmpty(pn) || !pn.startsWith("+7")) {
            errors.reject(
                    "invalid.phone",
                    "Invalid phone number");
        }
    }
}
