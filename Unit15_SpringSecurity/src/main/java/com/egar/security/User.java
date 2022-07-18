package com.egar.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role implements GrantedAuthority {
        USER,
        ADMIN;

        @Override
        public String getAuthority() {
            return name();
        }
    }
}
