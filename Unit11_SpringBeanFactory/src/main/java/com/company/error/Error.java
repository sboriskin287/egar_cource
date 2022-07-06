package com.company.error;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class Error {

    private String message;

    private String code;

    private LocalDate timestamp;
}
