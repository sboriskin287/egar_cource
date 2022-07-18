package com.egar.security;

import lombok.Data;
import lombok.Setter;

@Data
public class TokenDto {
    @Setter
    private String accessToken;
}
