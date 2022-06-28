package com.company.converter;

import com.company.domain.elf.Elf;
import com.company.domain.elf.dto.ElfRes;
import com.company.domain.elf.mapper.ElfMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ElfElfResConverter implements Converter<Elf, ElfRes> {
    private final ElfMapper elfMapper;

    @Override
    public ElfRes convert(Elf source) {
        return elfMapper.toElfRes(source);
    }
}
