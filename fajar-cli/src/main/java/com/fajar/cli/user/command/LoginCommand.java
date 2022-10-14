package com.fajar.cli.user.command;

import com.fajar.cli.user.payload.response.UserResponse;
import com.fajar.cli.user.service.UserLogin;
import com.fajar.cli.user.payload.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import javax.validation.constraints.NotNull;

@ShellComponent
@RequiredArgsConstructor
public class LoginCommand {

    private final UserLogin userLogin;

    @ShellMethod("User login")
    public String login(@ShellOption(value = "-u") @NotNull String username) {
        UserResponse userResponse = userLogin.authenticate(new LoginRequest(username));
        return String.format("Hello %s!", userResponse.getUsername()) +
            "\n" +
            String.format("Your balance is $%s ", userResponse.getBalance());
    }
}
