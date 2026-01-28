package com.gabrielle.ecommerce.domain.entity.Purchase;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "purchase")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @NotNull
    private UUID clientId;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    @NotNull
    @NotBlank
    private String paymentMethod;

    @OneToMany( mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PurchaseItemEntity> items = new ArrayList<>();
}
