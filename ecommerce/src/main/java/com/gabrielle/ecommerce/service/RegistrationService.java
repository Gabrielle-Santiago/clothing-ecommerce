package com.gabrielle.ecommerce.service;

import com.gabrielle.ecommerce.mapper.ClientMapper;
import com.gabrielle.ecommerce.mapper.SellerMapper;
import com.gabrielle.ecommerce.model.dto.RegisterClientDTO;
import com.gabrielle.ecommerce.model.dto.RegisterSellerDTO;
import com.gabrielle.ecommerce.model.entity.ClientEntity;
import com.gabrielle.ecommerce.model.entity.SellerEntity;
import com.gabrielle.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final SellerMapper sellerMapper;
    private final ClientMapper clientMapper;

    public RegistrationService(UserRepository userRepository, SellerMapper sellerMapper, ClientMapper clientMapper) {
        this.userRepository = userRepository;
        this.sellerMapper = sellerMapper;
        this.clientMapper = clientMapper;
    }

    public void registerSeller(RegisterSellerDTO dto) {
        SellerEntity seller = sellerMapper.toEntity(dto);
        userRepository.save(seller);
    }

    public void registerClient(RegisterClientDTO dto){
        ClientEntity client = clientMapper.toEntity(dto);
        userRepository.save(client);
    }
}
