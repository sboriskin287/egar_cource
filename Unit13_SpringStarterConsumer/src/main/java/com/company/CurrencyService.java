package com.company;

import com.company.currency.Currency;
import com.company.currency.EurCurrency;
import com.company.currency.RubCurrency;
import com.company.currency.UsdCurrency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final Currency currency;

    @PostConstruct
    public void init() {
        System.out.printf("Валюта %s, курс %s ",
                currency.printName(),
                currency.courseByRubble().toString());
    }
}
