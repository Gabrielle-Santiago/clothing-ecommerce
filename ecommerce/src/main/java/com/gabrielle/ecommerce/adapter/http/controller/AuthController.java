package com.gabrielle.ecommerce.adapter.http.controller;

import com.gabrielle.ecommerce.adapter.security.auth.AuthenticateLoginUseCase;
import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshRequest;
import com.gabrielle.ecommerce.adapter.security.token.refresh.dto.TokenRefreshResponse;
import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshUseCase;
import com.gabrielle.ecommerce.application.dto.*;
import com.gabrielle.ecommerce.application.service.RegistraterUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticateLoginUseCase authenticateLogin;
    private final RegistraterUserService service;
    private final TokenRefreshUseCase tokenRefresh;

    public AuthController(AuthenticateLoginUseCase authenticateLogin, RegistraterUserService service, TokenRefreshUseCase tokenRefresh) {
        this.authenticateLogin = authenticateLogin;
        this.service = service;
        this.tokenRefresh = tokenRefresh;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenRefreshResponse> login(@RequestBody @Valid LoginDTO dto){
        TokenRefreshResponse response = authenticateLogin.execute(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenRefreshResponse> refresh(@RequestBody @Valid TokenRefreshRequest request) {
        TokenRefreshResponse response = tokenRefresh.refresh(request.refreshToken());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register/client")
    public ResponseEntity<String> registerClient(@RequestBody @Valid RegisterClientDTO dto){
        service.registerClient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Client registered successfully!");
    }

    @PostMapping("/register/seller")
    public ResponseEntity<String> registerSeller(@RequestBody @Valid RegisterSellerDTO dto){
        service.registerSeller(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Seller registered successfully!");
    }
}
