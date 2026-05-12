package com.gabrielle.ecommerce.domain.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

import com.gabrielle.ecommerce.domain.enums.PaymentStatus;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private UUID purchaseId;
    private Instant createdAt;
    private String statusDetail;
    private String externalId;
    private String checkoutUrl;
    private String payerEmail;
    private BigDecimal amount;
    private LocalDateTime updateAt;
}
