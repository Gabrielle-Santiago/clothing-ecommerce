package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.domain.enums.PaymentStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Payment {
    private UUID id;
    private PaymentStatus status;
    private final UUID purchaseId;
    private String checkoutUrl;
    private String payerEmail;
    private BigDecimal amount;

    private Payment(UUID id, PaymentStatus status, UUID purchaseId, String checkoutUrl, String payerEmail, BigDecimal amount) {
        this.id = id;
        this.purchaseId = purchaseId;
        this.status = status;
        this.checkoutUrl = checkoutUrl;
        this.payerEmail = payerEmail;
        this.amount = amount;
    }

    public static Payment create(UUID purchaseId, String payerEmail, BigDecimal amount) {
        return new Payment(
                UUID.randomUUID(),
                PaymentStatus.PENDING,
                purchaseId,
                null,
                payerEmail,
                amount
        );
    }

    public void process(){
        if (status != PaymentStatus.PENDING) {
            throw new IllegalStateException("Only PENDING can be in process");
        }
        this.status = PaymentStatus.IN_PROCESS;
    }

    public void approve(){
        if (status != PaymentStatus.IN_PROCESS  && status != PaymentStatus.IN_PROCESS) {
            throw new IllegalStateException("Only IN PROCESS can be approved");
        }
        this.status = PaymentStatus.APPROVED;
    }

    public void cancel(){
        if (status != PaymentStatus.PENDING && status != PaymentStatus.IN_PROCESS) {
            throw new IllegalStateException("Only PENDING can be cancelled");
        }
        this.status = PaymentStatus.CANCELLED;
    }

    public void reject(){
        if (status != PaymentStatus.PENDING && status != PaymentStatus.IN_PROCESS) {
            throw new IllegalStateException("Only IN PROCESS can be rejected");
        }
        this.status = PaymentStatus.REJECTED;
    }

    public static Payment restore(
            UUID id,
            PaymentStatus status,
            UUID purchaseId,
            String checkoutUrl,
            String payerEmail,
            BigDecimal amount
    ) {
        if (id == null) {
            throw new IllegalArgumentException("Payment id cannot be null");
        }

        if (status == null) {
            throw new IllegalArgumentException("Payment status cannot be null");
        }

        if (purchaseId == null) {
            throw new IllegalArgumentException("Purchase id cannot be null");
        }

        if (payerEmail == null || payerEmail.isBlank()) {
            throw new IllegalArgumentException("Payer email cannot be null or blank");
        }

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        return new Payment(
                id,
                status,
                purchaseId,
                checkoutUrl,
                payerEmail,
                amount
        );
    }
}
