package com.gabrielle.ecommerce.adapter.product;

import com.gabrielle.ecommerce.application.service.impl.UserDetailsImpl;
import com.gabrielle.ecommerce.domain.entity.user.UserEntity;
import com.gabrielle.ecommerce.ports.SellerLookupPort;
import com.gabrielle.ecommerce.shared.exception.NotFoundUser;
import com.gabrielle.ecommerce.shared.exception.authentication.UserNotAuthenticatedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SellerLookupAdapter implements SellerLookupPort {
    @Override
    public UUID getCurrentSellerId() {

        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            throw new UserNotAuthenticatedException("User not authenticated");
        }

        UserDetailsImpl principal = (UserDetailsImpl) auth.getPrincipal();
        UserEntity user = principal.getUser();

        if (!user.getRole().getRole().equals("SELLER")) {
            throw new NotFoundUser("This user is not a seller");
        }

        return user.getId();
    }
}

