package com.gabrielle.ecommerce.application.mapper.user;

import com.gabrielle.ecommerce.application.dto.user.RegisterSellerDTO;
import com.gabrielle.ecommerce.domain.entity.user.SellerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-06T09:27:53-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class SellerMapperImpl implements SellerMapper {

    @Override
    public SellerEntity toEntity(RegisterSellerDTO sellerDTO) {
        if ( sellerDTO == null ) {
            return null;
        }

        SellerEntity sellerEntity = new SellerEntity();

        sellerEntity.setUsername( sellerDTO.username() );
        sellerEntity.setName( sellerDTO.name() );
        sellerEntity.setEmail( sellerDTO.email() );
        sellerEntity.setAge( sellerDTO.age() );
        sellerEntity.setNumber( sellerDTO.number() );
        sellerEntity.setCnpj( sellerDTO.cnpj() );
        sellerEntity.setStoreName( sellerDTO.storeName() );

        sellerEntity.setRole( com.gabrielle.ecommerce.domain.enums.UserRole.SELLER );
        sellerEntity.setPasswd( new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(sellerDTO.passwd()) );

        return sellerEntity;
    }
}
