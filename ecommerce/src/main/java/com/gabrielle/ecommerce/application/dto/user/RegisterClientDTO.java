package com.gabrielle.ecommerce.application.dto.user;

import com.gabrielle.ecommerce.domain.enums.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "RegisterClientRequest",
        description = "Request payload used to register a new client account"
)
public record RegisterClientDTO(

        @Schema(
                description = "Unique username used for authentication",
                example = "client_123"
        )
        String username,

        @Schema(
                description = "User password",
                example = "StrongPassword123"
        )
        String passwd,

        @Schema(
                description = "Full name of the client",
                example = "Ana Souza"
        )
        String name,

        @Schema(
                description = "Client email address",
                example = "client@email.com"
        )
        String email,

        @Schema(
                description = "Client age",
                example = "30"
        )
        int age,

        @Schema(
                description = "Client phone number",
                example = "+55 21 98888-7777"
        )
        String number,

        @Schema(
                description = "Role assigned to the user",
                example = "CLIENT"
        )
        UserRole role,

        @Schema(
                description = "Brazilian personal tax identification number (CPF)",
                example = "123.456.789-00"
        )
        String cpf,

        @Schema(
                description = "Client residential address",
                example = "Av. Paulista, 1000 - São Paulo, SP"
        )
        String adress

) {}

