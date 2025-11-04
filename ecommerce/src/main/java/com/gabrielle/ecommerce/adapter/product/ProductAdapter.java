package com.gabrielle.ecommerce.adapter.product;

import com.gabrielle.ecommerce.application.mapper.product.ProductPersistenceMapper;
import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.domain.entity.ProductEntity;
import com.gabrielle.ecommerce.ports.repository.ProductJpaRepository;
import com.gabrielle.ecommerce.ports.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProductAdapter implements ProductRepository {
    public final ProductJpaRepository repository;
    public final ProductPersistenceMapper mapper;

    public ProductAdapter(ProductJpaRepository repository, ProductPersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entityToSave = mapper.toEntity(product);
        ProductEntity savedEntity = repository.save(entityToSave);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Product> findProdutById(UUID id) {
        Optional<ProductEntity> entity = repository.findById(id);
        return entity.map(mapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> entity = repository.findAll();
        return entity.stream().map(mapper::toDomain).collect(Collectors.toList());
    }
}
