package com.fajar.cli.user.payload.response;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class DepositResponse {

    BigDecimal totalBalance;

    String message;

    private DepositResponse(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
        this.message = String.format("Your balance is $%s!", totalBalance);
    }

    public static DepositResponse valueOf(BigDecimal totalBalance) {
        return new DepositResponse(totalBalance);
    }

}
