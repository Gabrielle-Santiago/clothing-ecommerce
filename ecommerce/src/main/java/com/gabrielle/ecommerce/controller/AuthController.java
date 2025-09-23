package com.gabrielle.ecommerce.controller;

import com.gabrielle.ecommerce.model.dto.LoginDTO;
import com.gabrielle.ecommerce.model.dto.RegisterClientDTO;
import com.gabrielle.ecommerce.model.dto.RegisterSellerDTO;
import com.gabrielle.ecommerce.model.dto.TokenLoginDTO;
import com.gabrielle.ecommerce.service.AuthenticationService;
import com.gabrielle.ecommerce.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authentication;
    private final RegistrationService service;

    public AuthController(AuthenticationService authentication, RegistrationService service) {
        this.authentication = authentication;
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenLoginDTO> login(@RequestBody @Valid LoginDTO dto){
        String token = authentication.authenticateUser(dto);
        return ResponseEntity.ok(new TokenLoginDTO(token));
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
