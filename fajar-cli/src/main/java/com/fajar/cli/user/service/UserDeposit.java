package com.fajar.cli.user.service;

import com.fajar.cli.user.payload.request.DepositRequest;
import com.fajar.cli.user.payload.response.DepositResponse;

public interface UserDeposit {

    DepositResponse deposit(DepositRequest request);
}
