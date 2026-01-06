package com.gabrielle.ecommerce.application.mapper.user;

import com.gabrielle.ecommerce.application.dto.user.RegisterClientDTO;
import com.gabrielle.ecommerce.domain.entity.user.ClientEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-06T09:27:52-0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.14.3.jar, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientEntity toEntity(RegisterClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setUsername( clientDTO.username() );
        clientEntity.setName( clientDTO.name() );
        clientEntity.setEmail( clientDTO.email() );
        clientEntity.setAge( clientDTO.age() );
        clientEntity.setNumber( clientDTO.number() );
        clientEntity.setCpf( clientDTO.cpf() );
        clientEntity.setAdress( clientDTO.adress() );

        clientEntity.setRole( com.gabrielle.ecommerce.domain.enums.UserRole.CLIENT );
        clientEntity.setPasswd( new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(clientDTO.passwd()) );

        return clientEntity;
    }
}
