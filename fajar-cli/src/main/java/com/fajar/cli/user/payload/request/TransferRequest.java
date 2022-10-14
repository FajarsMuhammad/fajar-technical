package com.fajar.cli.user.payload.request;

import com.fajar.cli.user.model.User;
import com.fajar.cli.user.model.UserBalance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor(staticName = "valueOf")
public class TransferRequest {

    @With
    String username;

    String toUsername;

    BigDecimal transfer;

    public UserBalance toUserBalance(User user, UserBalance.BalanceType balanceType) {
        return UserBalance.builder()
            .balance(transfer)
            .user(user)
            .balanceType(balanceType)
            .build();
    }

}
