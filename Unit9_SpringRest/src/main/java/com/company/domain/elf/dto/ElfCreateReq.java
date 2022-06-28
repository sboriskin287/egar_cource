package com.company.domain.elf.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
public class ElfCreateReq {

    @NotNull
    private String name;

    @NotNull
    private Float health;

    @Min(30)
    @Max(500)
    private Float damage;
}
