package com.gabrielle.ecommerce.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "sellers")
@PrimaryKeyJoinColumn(name = "user_id")
public class SellerEntity extends UserEntity{
    private String cnpj;
    private String storeName;
}
