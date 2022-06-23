package com.company.domain.elf;

import com.company.domain.Hero;
import com.company.domain.elf.dto.ElfCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElfService {
    private final ElfRepo elfRepo;

    public List<Elf> findAllElfs() {
        return elfRepo.findAll();
    }

    public Elf saveElf(ElfCreateReq req) {
        Hero h = new Hero();
        Elf e = new Elf();
        e.setHero(h);
        h.setName(req.getName());
        h.setHealth(req.getHealth());
        h.setDamage(req.getDamage());
        return elfRepo.save(e);
    }
}
