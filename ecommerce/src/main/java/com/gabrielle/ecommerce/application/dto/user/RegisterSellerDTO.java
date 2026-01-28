package com.gabrielle.ecommerce.application.dto.user;

import com.gabrielle.ecommerce.domain.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

@Schema(
        name = "RegisterSellerRequest",
        description = "Request payload used to register a new seller account"
)
public record RegisterSellerDTO(

        @Schema(
                description = "Unique username used for authentication",
                example = "seller_123"
        )
        @NotNull
        @NotBlank
        String username,

        @Schema(
                description = "User password",
                example = "StrongPassword123"
        )
        @NotNull
        String passwd,

        @Schema(
                description = "Full name of the seller",
                example = "Gabriel Silva"
        )
        String name,

        @Schema(
                description = "Seller email address",
                example = "seller@email.com"
        )
        @Email
        String email,

        @Schema(
                description = "Seller age",
                example = "25"
        )
        int age,

        @Schema(
                description = "Seller phone number",
                example = "+55 11 99999-9999"
        )
        String number,

        @Schema(
                description = "Role assigned to the user",
                example = "SELLER"
        )
        @Enumerated(EnumType.STRING)
        UserRole role,

        @Schema(
                description = "Brazilian company registration number (CNPJ)",
                example = "12.345.678/0001-90"
        )
        String cnpj,

        @Schema(
                description = "Store or business name",
                example = "Gabriel Tech Store"
        )
        String storeName

) {}

