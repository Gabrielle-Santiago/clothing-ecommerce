package com.gabrielle.ecommerce.application.mapper.product;

import com.gabrielle.ecommerce.domain.Product;
import com.gabrielle.ecommerce.domain.entity.ProductEntity;
import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-22T10:50:38-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProductPersistenceMapperImpl implements ProductPersistenceMapper {

    @Override
    public Product toDomain(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID sellerId = null;
        UUID id = null;
        String nameProduct = null;
        String size = null;
        int quant = 0;
        BigDecimal price = null;
        String describe = null;
        String img = null;

        sellerId = entity.getSeller();
        id = entity.getId();
        nameProduct = entity.getNameProduct();
        size = entity.getSize();
        quant = entity.getQuant();
        price = entity.getPrice();
        describe = entity.getDescribe();
        img = entity.getImg();

        Product product = new Product( id, nameProduct, size, quant, price, describe, img, sellerId );

        return product;
    }

    @Override
    public ProductEntity toEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setSeller( product.getSellerId() );
        productEntity.setId( product.getId() );
        productEntity.setNameProduct( product.getNameProduct() );
        productEntity.setSize( product.getSize() );
        productEntity.setQuant( product.getQuant() );
        productEntity.setPrice( product.getPrice() );
        productEntity.setDescribe( product.getDescribe() );
        productEntity.setImg( product.getImg() );

        return productEntity;
    }
}
