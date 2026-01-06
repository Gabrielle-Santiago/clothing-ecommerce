package com.gabrielle.ecommerce.application.mapper.product;

import com.gabrielle.ecommerce.application.dto.product.ProductResponseDTO;
import com.gabrielle.ecommerce.domain.Product;
import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-06T09:27:53-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProductResponseMapperImpl implements ProductResponseMapper {

    @Override
    public ProductResponseDTO toDTO(Product domain) {
        if ( domain == null ) {
            return null;
        }

        UUID id = null;
        String nameProduct = null;
        String size = null;
        int quant = 0;
        BigDecimal price = null;
        String describe = null;
        String img = null;

        id = domain.getId();
        nameProduct = domain.getNameProduct();
        size = domain.getSize();
        quant = domain.getQuant();
        price = domain.getPrice();
        describe = domain.getDescribe();
        img = domain.getImg();

        ProductResponseDTO productResponseDTO = new ProductResponseDTO( id, nameProduct, size, quant, price, describe, img );

        return productResponseDTO;
    }
}
