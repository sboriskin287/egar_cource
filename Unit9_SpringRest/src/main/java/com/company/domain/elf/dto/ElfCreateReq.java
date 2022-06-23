package com.company.domain.elf.dto;

import lombok.Data;

@Data
public class ElfCreateReq {

    private String name;

    private Float health;

    private Float damage;
}
