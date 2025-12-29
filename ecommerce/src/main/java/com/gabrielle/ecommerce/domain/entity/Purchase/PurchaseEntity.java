package com.gabrielle.ecommerce.domain.entity.Purchase;

import jakarta.persistence.*;
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

    private UUID clientId;
    private BigDecimal total;
    private String paymentMethod;

    @OneToMany( mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PurchaseItemEntity> items = new ArrayList<>();
}
