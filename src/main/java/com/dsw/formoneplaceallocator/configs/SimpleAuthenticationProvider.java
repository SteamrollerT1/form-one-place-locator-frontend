package com.dsw.formoneplaceallocator.configs;

import com.dsw.formoneplaceallocator.services.iface.SecurityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@Slf4j
public class SimpleAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SecurityService securityService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (securityService.authenticate(username, password)) {
            return new UsernamePasswordAuthenticationToken(
                    username, password, Collections.emptyList());
        } else {
            throw new RuntimeException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
