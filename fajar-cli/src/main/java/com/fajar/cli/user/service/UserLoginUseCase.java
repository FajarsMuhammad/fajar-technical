package com.fajar.cli.user.service;

import com.fajar.cli.user.model.User;
import com.fajar.cli.user.payload.response.UserResponse;
import com.fajar.cli.user.repository.UserJpaRepository;
import com.fajar.cli.user.payload.request.LoginRequest;
import com.fajar.security.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserLoginUseCase implements UserLogin {

    private final UserJpaRepository userJpaRepository;

    @Transactional
    public UserResponse authenticate(LoginRequest loginRequest) {

        User user = userJpaRepository
            .findByUsername(loginRequest.getUsername())
            .orElseGet(() -> saveUser(loginRequest.getUsername()));

        Authentication authentication = new UsernamePasswordAuthenticationToken(
            new UserDetailsImpl(user.getId(), user.getUsername()),
            null);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return UserResponse.valueOf(user.getUsername(), user.getTotalBalance());
    }

    private User saveUser(String username) {
        return userJpaRepository.save(User.valueOf(username));
    }

}
