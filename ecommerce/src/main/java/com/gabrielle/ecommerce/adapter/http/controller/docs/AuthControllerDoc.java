package com.gabrielle.ecommerce.adapter.http.controller.docs;

import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshRequest;
import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshResponse;
import com.gabrielle.ecommerce.application.dto.user.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "User authentication",
        description = "Authentication and registration endpoints"
)
public interface AuthControllerDoc {

    @Operation(
            summary = "User authentication",
            description = "Authenticates user credentials and returns access and refresh tokens"
    )
    ResponseEntity<TokenRefreshResponse> login(
            @RequestBody @Valid LoginDTO dto
    );

    @Operation(
            summary = "Refresh access token",
            description = "Generates a new access token using a valid refresh token"
    )
    ResponseEntity<TokenRefreshResponse> refresh(
            @RequestBody @Valid TokenRefreshRequest request
    );

    @Operation(
            summary = "Client registration",
            description = "Registers a new client user"
    )
    ResponseEntity<String> registerClient(
            @RequestBody @Valid RegisterClientDTO dto
    );

    @Operation(
            summary = "Seller registration",
            description = "Registers a new seller user"
    )
    ResponseEntity<String> registerSeller(
            @RequestBody @Valid RegisterSellerDTO dto
    );
}


