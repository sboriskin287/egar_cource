package com.company.domain.elf.mapper;

import com.company.domain.elf.Elf;
import com.company.domain.elf.dto.ElfRes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ElfMapper {

    @Mapping(source = "elf.hero.name", target = "name")
    @Mapping(source = "elf.hero.health", target = "health")
    @Mapping(source = "elf.hero.damage", target = "damage")
    ElfRes toElfRes(Elf elf);

    List<ElfRes> toList(List<Elf> elfs);
}
