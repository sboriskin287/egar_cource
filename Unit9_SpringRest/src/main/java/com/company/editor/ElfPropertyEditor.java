package com.company.editor;

import com.company.domain.elf.Elf;
import com.company.domain.elf.ElfRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
@RequiredArgsConstructor
public class ElfPropertyEditor extends PropertyEditorSupport {
    private final ElfRepo elfRepo;

    @Override
    public String getAsText() {
        Elf elf = (Elf) getValue();
        return String.format("Наш объект %d", elf.getId());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Elf elf = elfRepo.findById(Integer.parseInt(text))
                .orElseThrow();
        setValue(elf);
    }
}
