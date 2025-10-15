package com.gabrielle.ecommerce.application.dto;

import com.gabrielle.ecommerce.domain.enums.UserRole;

public record RegisterClientDTO(
       String username,
       String passwd,
       String name,
       String email,
       int age,
       String number,
       UserRole role,
       String cpf,
       String adress
) {}
