package com.company;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class GreetingController {
    List<StringWrapper> content = new LinkedList<>();

    @GetMapping
    public List<StringWrapper> getAll() {
        return content;
    }

    @GetMapping("/{index}")
    public StringWrapper getByIndex(@PathVariable Integer index) {
        return content.get(index);
    }

    @PostMapping
    public StringWrapper add(@RequestBody StringWrapper str) {
        content.add(str);
        return str;
    }

    @PutMapping("/{index}")
    public StringWrapper replace(@PathVariable Integer index,
                                 @RequestBody StringWrapper str) {
        return content.set(index, str);
    }

    @DeleteMapping("/{index}")
    public StringWrapper delete(@PathVariable Integer index) {
        return content.remove(index.intValue());
    }
}
