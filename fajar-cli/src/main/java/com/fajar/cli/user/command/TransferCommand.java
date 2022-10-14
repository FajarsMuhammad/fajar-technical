package com.fajar.cli.user.command;

import com.fajar.cli.user.payload.request.TransferRequest;
import com.fajar.cli.user.payload.response.TransferResponse;
import com.fajar.cli.user.service.UserTransfer;
import com.fajar.cli.util.UserInfoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;

@ShellComponent
@RequiredArgsConstructor
public class TransferCommand {

    private final UserTransfer userTransfer;

    @ShellMethod("User transfer")
    public String transfer(@ShellOption(value = "-u") String user,
                           @ShellOption(value = "-t") BigDecimal transfer) {

        TransferResponse response = userTransfer
            .transfer(TransferRequest.valueOf(UserInfoUtil.getUsername(), user, transfer));

        return String.format("Transfered $%s to %s, Your balance $%s",
            transfer, user, response.getTotalBalance());
    }

}
