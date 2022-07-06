package com.company.domain;

import com.company.validator.Phone;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Domain {

    @NotEmpty
    private String str;

    @NotNull
    private Integer number;

    @Pattern(regexp = "\\d{2}.\\d{2}.\\d{4}")
    private String localDate;

    //@Phone(startWith = "+7")
    private String phoneNumber;
}
