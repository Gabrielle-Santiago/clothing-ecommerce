package com.gabrielle.ecommerce.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "user_id")
public class ClientEntity extends UserEntity{
    private String cpf;
    private String adress;
}
