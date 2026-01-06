package com.gabrielle.ecommerce.domain.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Current status of the purchase")
public enum PurchaseStatus {
    APPROVED("APPROVED"),
    PENDING("PENDING"),
    REJECTED("REJECTED");

    private final String status;

    PurchaseStatus(String status) {
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
