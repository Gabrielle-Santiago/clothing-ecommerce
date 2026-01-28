package com.gabrielle.ecommerce.adapter;

import com.gabrielle.ecommerce.application.service.impl.UserDetailsImpl;
import com.gabrielle.ecommerce.domain.entity.user.UserEntity;
import com.gabrielle.ecommerce.ports.ClientLookupPort;
import com.gabrielle.ecommerce.shared.exception.authentication.UserNotAuthenticatedException;
import com.gabrielle.ecommerce.shared.exception.authentication.UserNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClientLookupAdapter implements ClientLookupPort {
    @Override
    public UUID getCurrentClientId() {
        var auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth.getPrincipal().equals("anonymousUser")) {
            throw new UserNotAuthenticatedException("User not authenticated");
        }

        UserDetailsImpl principal = (UserDetailsImpl) auth.getPrincipal();
        UserEntity user = principal.getUser();

        if (!user.getRole().getRole().equals("CLIENT")) {
            throw new UserNotFoundException("This user is not a client");
        }

        return user.getId();
    }
}
