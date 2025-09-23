package com.gabrielle.ecommerce.model.dto;

import com.gabrielle.ecommerce.model.enums.UserRole;

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
