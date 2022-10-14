package com.fajar.cli.user.payload.response;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class TransferResponse {

    BigDecimal totalBalance;

    String toUser;

    private TransferResponse(BigDecimal totalBalance, String toUser) {
        this.totalBalance = totalBalance;
        this.toUser = toUser;
    }

    public static TransferResponse valueOf(BigDecimal totalBalance, String toUser) {
        return new TransferResponse(totalBalance, toUser);
    }

}
