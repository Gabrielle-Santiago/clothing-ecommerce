package com.gabrielle.ecommerce.domain.enums;

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
