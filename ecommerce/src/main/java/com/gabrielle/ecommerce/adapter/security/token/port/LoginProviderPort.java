package com.gabrielle.ecommerce.adapter.security.token.port;

import com.gabrielle.ecommerce.adapter.security.auth.AuthenticatedUser;

public interface LoginProviderPort {
    AuthenticatedUser authenticate(String username, String passwd);
}
