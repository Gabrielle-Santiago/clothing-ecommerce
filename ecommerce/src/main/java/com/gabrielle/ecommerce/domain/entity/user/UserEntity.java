package com.gabrielle.ecommerce.domain.entity.user;

import com.gabrielle.ecommerce.domain.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String passwd;

    private String name;

    @Email
    @Pattern(regexp=".+@.+\\..+", message = "Email invalid")
    private String email;

    private int age;
    private String number;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
