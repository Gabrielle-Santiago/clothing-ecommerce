package com.gabrielle.ecommerce.adapter;

import com.gabrielle.ecommerce.application.mapper.user.SellerPersistenceMapper;
import com.gabrielle.ecommerce.domain.Seller;
import com.gabrielle.ecommerce.ports.repository.user.SellerJpaRepository;
import com.gabrielle.ecommerce.ports.repository.user.SellerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class SellerAdapter implements SellerRepository {
    private final SellerJpaRepository repository;
    private final SellerPersistenceMapper mapper;

    public SellerAdapter(SellerJpaRepository repository, SellerPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Seller> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }
}
