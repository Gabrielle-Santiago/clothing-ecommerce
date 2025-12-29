package com.gabrielle.ecommerce.ports.repository.user;

import com.gabrielle.ecommerce.domain.entity.user.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SellerJpaRepository extends JpaRepository<SellerEntity, UUID> {}
