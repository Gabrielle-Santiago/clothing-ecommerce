package com.gabrielle.ecommerce.adapter.security.token.refresh.repository;

import com.gabrielle.ecommerce.adapter.security.token.refresh.TokenRefreshEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Repository
public interface TokenRefreshJpaRepository extends JpaRepository<TokenRefreshEntity, String> {
    @Override
    Optional<TokenRefreshEntity> findById(String token);

    @Transactional
    @Modifying
    @Query("DELETE FROM TokenRefreshEntity t WHERE t.expiryDate < :now")
    void deleteTokenByExpirationDate(Instant now);
}
