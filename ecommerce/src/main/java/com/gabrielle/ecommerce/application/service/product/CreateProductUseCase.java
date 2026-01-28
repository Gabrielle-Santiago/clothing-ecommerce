package com.gabrielle.ecommerce.application.service.product;

import com.gabrielle.ecommerce.application.dto.product.ProductRequestDTO;
import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import com.gabrielle.ecommerce.application.mapper.product.*;
import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.domain.Seller;
import com.gabrielle.ecommerce.ports.SellerLookupPort;
import com.gabrielle.ecommerce.ports.repository.product.ProductRepository;
import com.gabrielle.ecommerce.ports.repository.user.SellerRepository;
import com.gabrielle.ecommerce.shared.exception.authentication.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CreateProductUseCase {
    public final ProductRepository productRepository;
    public final SellerRepository sellerRepository;
    public final ProductRequestMapper requestMapper;
    public final ProductResponseMapper responseMapper;
    public final SellerLookupPort sellerLookupPort;

    public CreateProductUseCase(ProductRepository productRepository, SellerRepository sellerRepository,
                                ProductRequestMapper requestMapper, ProductResponseMapper responseMapper, SellerLookupPort sellerLookupPort
    ) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
        this.sellerLookupPort = sellerLookupPort;
    }

    @Transactional
    public ProductResponseDTO execute(ProductRequestDTO requestDTO) {
        UUID  sellerId = sellerLookupPort.getCurrentSellerId();
        Seller seller = sellerRepository.findById(sellerId)
                .orElseThrow(() -> new UserNotFoundException("Seller not found"));

        Product product = requestMapper.toDomain(requestDTO, seller);
        Product savedProduct = productRepository.save(product);

        return responseMapper.toDTO(savedProduct);
    }
}