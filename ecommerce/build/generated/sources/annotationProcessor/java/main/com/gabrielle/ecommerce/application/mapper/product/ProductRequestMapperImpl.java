package com.gabrielle.ecommerce.application.mapper.product;

import com.gabrielle.ecommerce.application.dto.product.ProductRequestDTO;
import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.domain.Seller;
import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-22T10:50:36-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProductRequestMapperImpl implements ProductRequestMapper {

    @Override
    public Product toDomain(ProductRequestDTO requestDTO, Seller seller) {
        if ( requestDTO == null && seller == null ) {
            return null;
        }

        String nameProduct = null;
        String size = null;
        int quant = 0;
        BigDecimal price = null;
        String describe = null;
        String img = null;
        if ( requestDTO != null ) {
            nameProduct = requestDTO.nameProduct();
            size = requestDTO.size();
            quant = requestDTO.quant();
            price = requestDTO.price();
            describe = requestDTO.describe();
            img = requestDTO.img();
        }

        UUID id = null;
        UUID sellerId = null;

        Product product = new Product( id, nameProduct, size, quant, price, describe, img, sellerId );

        return product;
    }
}
