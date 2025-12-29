package com.gabrielle.ecommerce.ports.repository.user;

import com.gabrielle.ecommerce.domain.Seller;

import java.util.Optional;
import java.util.UUID;

public interface SellerRepository {
    Optional<Seller> findById(UUID id);
}
