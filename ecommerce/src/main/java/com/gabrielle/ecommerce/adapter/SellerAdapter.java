package com.gabrielle.ecommerce.adapter;

import com.gabrielle.ecommerce.application.mapper.SellerPersistenceMapper;
import com.gabrielle.ecommerce.domain.Seller;
import com.gabrielle.ecommerce.ports.repository.SellerJpaRepository;
import com.gabrielle.ecommerce.ports.repository.SellerRepository;
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
