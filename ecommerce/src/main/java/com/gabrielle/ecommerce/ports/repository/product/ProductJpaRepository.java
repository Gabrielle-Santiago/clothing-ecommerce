package com.gabrielle.ecommerce.ports.repository.product;

import com.gabrielle.ecommerce.domain.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, UUID> {}
