package com.fajar.cli.user.service;

import com.fajar.cli.user.model.User;
import com.fajar.cli.user.model.UserBalance;
import com.fajar.cli.user.payload.request.DepositRequest;
import com.fajar.cli.user.payload.response.DepositResponse;
import com.fajar.cli.user.repository.UserBalanceJpaRepository;
import com.fajar.cli.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDepositUseCase implements UserDeposit {

    private final UserJpaRepository userJpaRepository;

    private final UserBalanceJpaRepository userBalanceJpaRepository;

    @Override
    @Transactional
    public DepositResponse deposit(DepositRequest request) {

        User user = userJpaRepository
            .findByUsername(request.getUsername())
            .orElseThrow(() -> new UsernameNotFoundException("username not found please login"));

        saveUserBalance(user, request);

        return DepositResponse.valueOf(user.getTotalBalance());
    }

    private void saveUserBalance(User user, DepositRequest request) {
        user.addBalance(request.getDeposit());
        userBalanceJpaRepository.save(request.toUserBalance(user, UserBalance.BalanceType.DEBIT));
    }
}
