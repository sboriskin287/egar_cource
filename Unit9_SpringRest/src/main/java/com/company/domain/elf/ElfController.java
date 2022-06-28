package com.company.domain.elf;

import com.company.domain.elf.dto.ElfCreateReq;
import com.company.domain.elf.dto.ElfRes;
import com.company.domain.elf.mapper.ElfMapper;
import com.company.editor.ElfPropertyEditor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ElfController {
    private final ElfService elfService;
    private final ElfMapper elfMapper;
    private final ElfPropertyEditor elfPropertyEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Elf.class, elfPropertyEditor);
    }

    @GetMapping
    public List<ElfRes> findAllElves() {
        List<Elf> elves = elfService.findAllElfs();
        return elfMapper.toList(elves);
    }

    @GetMapping("/{id}")
    public Elf findOneElf(@PathVariable("id") Elf elf) {
        return elf;
    }

    @PostMapping
    public ElfRes saveElf(@RequestBody @Valid ElfCreateReq req) {
        Elf elf = elfService.saveElf(req);
        return elfMapper.toElfRes(elf);
    }
}
