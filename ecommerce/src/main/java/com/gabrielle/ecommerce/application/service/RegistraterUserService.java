package com.gabrielle.ecommerce.application.service;

import com.gabrielle.ecommerce.domain.entity.user.ClientEntity;
import com.gabrielle.ecommerce.domain.entity.user.SellerEntity;
import com.gabrielle.ecommerce.application.mapper.user.ClientMapper;
import com.gabrielle.ecommerce.application.mapper.user.SellerMapper;
import com.gabrielle.ecommerce.application.dto.user.RegisterClientDTO;
import com.gabrielle.ecommerce.application.dto.user.RegisterSellerDTO;
import com.gabrielle.ecommerce.ports.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistraterUserService {
    private final UserRepository userRepository;
    private final SellerMapper sellerMapper;
    private final ClientMapper clientMapper;

    public RegistraterUserService(UserRepository userRepository, SellerMapper sellerMapper, ClientMapper clientMapper) {
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
