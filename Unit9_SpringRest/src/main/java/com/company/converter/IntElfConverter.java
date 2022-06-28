package com.company.converter;

import com.company.domain.elf.Elf;
import com.company.domain.elf.ElfRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntElfConverter implements Converter<String, Elf> {
    private final ElfRepo elfRepo;

    @Override
    public Elf convert(String source) {
        return elfRepo.findById(Integer.valueOf(source))
                .orElseThrow();
    }
}
