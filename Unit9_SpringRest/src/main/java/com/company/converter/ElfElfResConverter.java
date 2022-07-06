package com.company.converter;

import com.company.domain.elf.Elf;
import com.company.domain.elf.dto.ElfRes;
import com.company.domain.elf.mapper.ElfMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class ElfElfResConverter implements Converter<String, LocalDate> {
    private final ElfMapper elfMapper;

    @Override
    public LocalDate convert(String source) {
        return LocalDate.parse(source, DateTimeFormatter.ISO_DATE_TIME);
    }
}
