package com.gabrielle.ecommerce.application.mapper.user;

import com.gabrielle.ecommerce.domain.Seller;
import com.gabrielle.ecommerce.domain.entity.user.SellerEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-19T06:55:27-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class SellerPersistenceMapperImpl implements SellerPersistenceMapper {

    @Override
    public SellerEntity toEntity(Seller seller) {
        if ( seller == null ) {
            return null;
        }

        SellerEntity sellerEntity = new SellerEntity();

        sellerEntity.setId( seller.getId() );
        sellerEntity.setUsername( seller.getUsername() );
        sellerEntity.setEmail( seller.getEmail() );

        return sellerEntity;
    }

    @Override
    public Seller toDomain(SellerEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UUID id = null;
        String username = null;
        String email = null;

        id = entity.getId();
        username = entity.getUsername();
        email = entity.getEmail();

        String hashPassword = null;

        Seller seller = new Seller( id, username, email, hashPassword );

        return seller;
    }
}
