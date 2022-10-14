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
public class DepositRequest {

    @With
    String username;

    BigDecimal deposit;

    public UserBalance toUserBalance(User user, UserBalance.BalanceType balanceType) {
        return UserBalance.builder()
            .balance(deposit)
            .user(user)
            .balanceType(balanceType)
            .build();
    }

}
