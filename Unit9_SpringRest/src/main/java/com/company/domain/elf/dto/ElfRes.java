package com.company.domain.elf.dto;

import com.company.audit.Audit;
import lombok.Data;

@Data
public class ElfRes {
    private Integer id;

    private String name;

    private Float health;

    private Float damage;

    private Audit audit = new Audit();
}
