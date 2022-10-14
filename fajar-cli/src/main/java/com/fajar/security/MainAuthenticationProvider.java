package com.fajar.security;

import com.fajar.cli.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class MainAuthenticationProvider implements AuthenticationProvider {

    private final UserJpaRepository userJpaRepository;

    @Override
    @Transactional
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        return userJpaRepository
            .findByUsername(username)
            .map(user -> new UsernamePasswordAuthenticationToken(
                user,
                authentication.getCredentials(),
                Collections.emptyList())
            )
            .orElseThrow(() -> new UsernameNotFoundException(
                String.format("Username %s not found", authentication.getName())
            ));

    }

    @Override
    public boolean supports(Class<?> auth) {
        return true;
    }

}