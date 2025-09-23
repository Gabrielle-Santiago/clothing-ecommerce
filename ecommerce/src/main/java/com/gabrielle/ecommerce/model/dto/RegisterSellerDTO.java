package com.gabrielle.ecommerce.model.dto;

import com.gabrielle.ecommerce.model.enums.UserRole;

public record RegisterSellerDTO(
        String username,
        String passwd,
        String name,
        String email,
        int age,
        String number,
        UserRole role,
        String cnpj,
        String storeName
) {}
