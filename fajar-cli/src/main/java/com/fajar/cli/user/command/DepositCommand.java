package com.fajar.cli.user.command;

import com.fajar.cli.user.payload.request.DepositRequest;
import com.fajar.cli.user.payload.response.DepositResponse;
import com.fajar.cli.user.service.UserDeposit;
import com.fajar.cli.util.UserInfoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;

@ShellComponent
@RequiredArgsConstructor
public class DepositCommand {

    private final UserDeposit userDeposit;

    @ShellMethod("User deposit")
    public String deposit(@ShellOption(value = "-d") BigDecimal deposit) {
        DepositResponse response =
            userDeposit.deposit(DepositRequest.valueOf(UserInfoUtil.getUsername(), deposit));
        return String.format("Your Balance $%s", response.getTotalBalance());
    }

}
