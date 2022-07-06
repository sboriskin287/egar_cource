package com.company;

import com.company.domain.Domain;
import com.company.domain.RandomIntBean;
import com.company.error.PhoneNumberException;
import com.company.validator.BodyValidator;
import com.company.validator.Phone;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
public class ValidatedController {
    private final BodyValidator bv;
    private final RandomIntBean bean;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(bv);
    }

    @PostMapping
    public Integer apply(@RequestBody @Valid Domain req) {
        return bean.getNumber();
    }
}
