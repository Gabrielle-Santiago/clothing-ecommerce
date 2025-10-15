package com.gabrielle.ecommerce.application.dto;

import com.gabrielle.ecommerce.domain.enums.UserRole;

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
