package com.gabrielle.ecommerce.domain.enums;

public enum PaymentStatus {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    IN_PROCESS("IN_PROCESS"),
    REJECTED("REJECTED"),
    CANCELLED("CANCELLED");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
