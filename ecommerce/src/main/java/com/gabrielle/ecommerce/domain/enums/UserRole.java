package com.gabrielle.ecommerce.domain.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User Roles")
public enum UserRole {
    CLIENT("CLIENT"),
    SELLER("SELLER");

    private final String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public static UserRole fromString(String roleStr){
        for (UserRole role: UserRole.values()){
            if(role.getRole().equalsIgnoreCase(roleStr)){
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " +  roleStr);
    }
}
