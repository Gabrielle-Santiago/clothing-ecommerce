package com.gabrielle.ecommerce.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Seller {
    private final UUID id;
    private final String username;
    private final String email;
    private final String hashPassword;

    public Seller(UUID id, String username, String email, String hashPassword) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.hashPassword = hashPassword;
    }
}
