package com.fajar.cli.user.service;

import com.fajar.cli.user.model.User;
import com.fajar.cli.user.model.UserBalance;
import com.fajar.cli.user.payload.request.TransferRequest;
import com.fajar.cli.user.payload.response.TransferResponse;
import com.fajar.cli.user.repository.UserBalanceJpaRepository;
import com.fajar.cli.user.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class UserTransferUseCase implements UserTransfer {

    private final UserJpaRepository userJpaRepository;

    private final UserBalanceJpaRepository userBalanceJpaRepository;

    @Override
    @Transactional
    public TransferResponse transfer(TransferRequest request) {

        User currenUser = getUser(request.getUsername());
        currenUser.decreaseBalance(request.getTransfer());
        saveUserBalance(currenUser, request, UserBalance.BalanceType.KREDIT);

        User trasferUser = getUser(request.getToUsername());
        trasferUser.addBalance(request.getTransfer());
        saveUserBalance(trasferUser, request, UserBalance.BalanceType.DEBIT);

        return TransferResponse.valueOf(currenUser.getTotalBalance(), trasferUser.getUsername());
    }

    private User getUser(String username) {
        return userJpaRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("usernot found"));
    }

    private void saveUserBalance(User user, TransferRequest request,
                                 UserBalance.BalanceType balanceType) {
        userBalanceJpaRepository.save(request.toUserBalance(user, balanceType));
    }
}
