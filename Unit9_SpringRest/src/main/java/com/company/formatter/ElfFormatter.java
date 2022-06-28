package com.company.formatter;

import com.company.domain.elf.Elf;
import com.company.domain.elf.ElfRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class ElfFormatter implements Formatter<Elf> {
    private final ElfRepo elfRepo;

    @Override
    public Elf parse(String text, Locale locale) throws ParseException {
        return elfRepo.findById(Integer.valueOf(text))
                .orElseThrow();
    }

    @Override
    public String print(Elf object, Locale locale) {
        return String.format("Наш объект %d", object.getId());
    }
}
