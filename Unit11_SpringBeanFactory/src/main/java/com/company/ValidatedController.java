package com.company;

import com.company.config.DomainProperty;
import com.company.domain.ActualBean;
import com.company.domain.DeprecatedBean;
import com.company.domain.Domain;
import com.company.domain.RandomIntBean;
import com.company.domain.TestDeprecatedBean;
import com.company.domain.TestProfilerBean;
import com.company.domain.TestProfilerBeanImpl;
import com.company.validator.BodyValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequiredArgsConstructor
public class ValidatedController {
    private final BodyValidator bv;
    private final RandomIntBean bean;
    private final TestProfilerBean tpb;
    private final TestDeprecatedBean actualBean;
    private final DomainProperty dm;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(bv);
    }

    @PostMapping
    public void apply(@RequestBody @Valid Domain req) {
        actualBean.print();
    }
}
