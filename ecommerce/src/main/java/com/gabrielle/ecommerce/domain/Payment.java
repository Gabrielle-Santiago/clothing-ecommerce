package com.gabrielle.ecommerce.domain;

import com.gabrielle.ecommerce.domain.enums.PaymentStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Payment {
    private UUID id;
    private PaymentStatus status;
    private UUID purchaseId;
    private String checkoutUrl;
    private String payerEmail;
    private BigDecimal amount;
    private String externalId;

    private Payment(
            UUID id,
            PaymentStatus status,
            UUID purchaseId,
            String checkoutUrl,
            String payerEmail,
            BigDecimal amount,
            String externalId
    ) {
        this.id = id;
        this.status = status;
        this.purchaseId = purchaseId;
        this.checkoutUrl = checkoutUrl;
        this.payerEmail = payerEmail;
        this.amount = amount;
        this.externalId = externalId;
    }

    public static Payment create(UUID purchaseId, String payerEmail, BigDecimal amount) {

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
                UUID.randomUUID(),
                PaymentStatus.PENDING,
                purchaseId,
                null,
                payerEmail,
                amount,
                null
        );
    }

    public static Payment restore(
            UUID id,
            PaymentStatus status,
            UUID purchaseId,
            String checkoutUrl,
            String payerEmail,
            BigDecimal amount,
            String externalId
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

        return new Payment(id, status, purchaseId, checkoutUrl, payerEmail, amount, externalId);
    }

    public void updatePaymentData(String checkoutUrl, String externalId) {

        if (checkoutUrl == null || checkoutUrl.isBlank()) {
            throw new IllegalArgumentException("Checkout URL cannot be null or blank");
        }

        if (externalId == null || externalId.isBlank()) {
            throw new IllegalArgumentException("External ID cannot be null or blank");
        }

        this.checkoutUrl = checkoutUrl;
        this.externalId = externalId;
    }

    public void process() {
        if (status != PaymentStatus.PENDING) {
            throw new IllegalStateException("Only PENDING can be in process");
        }
        this.status = PaymentStatus.IN_PROCESS;
    }

    public void approve() {
        if (status != PaymentStatus.IN_PROCESS) {
            throw new IllegalStateException("Only IN_PROCESS can be approved");
        }
        this.status = PaymentStatus.APPROVED;
    }

    public void cancel() {
        if (status != PaymentStatus.PENDING && status != PaymentStatus.IN_PROCESS) {
            throw new IllegalStateException("Only PENDING or IN_PROCESS can be cancelled");
        }
        this.status = PaymentStatus.CANCELLED;
    }

    public void reject() {
        if (status != PaymentStatus.PENDING && status != PaymentStatus.IN_PROCESS) {
            throw new IllegalStateException("Only PENDING or IN_PROCESS can be rejected");
        }
        this.status = PaymentStatus.REJECTED;
    }
}
