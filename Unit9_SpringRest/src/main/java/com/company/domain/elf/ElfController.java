package com.company.domain.elf;

import com.company.domain.elf.dto.ElfCreateReq;
import com.company.domain.elf.dto.ElfRes;
import com.company.domain.elf.mapper.ElfMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElfController {
    private final ElfService elfService;
    private final ElfMapper elfMapper;

    @GetMapping
    public List<ElfRes> findAllElfs() {
        List<Elf> elves = elfService.findAllElfs();
        return elfMapper.toList(elves);
    }

    @PostMapping
    public ElfRes saveElf(@RequestBody ElfCreateReq req) {
        Elf elf = elfService.saveElf(req);
        return elfMapper.toElfRes(elf);
    }
}
