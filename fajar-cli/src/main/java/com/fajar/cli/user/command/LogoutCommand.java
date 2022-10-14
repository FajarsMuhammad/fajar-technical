package com.fajar.cli.user.command;

import com.fajar.cli.user.service.UserLogin;
import com.fajar.cli.util.UserInfoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class LogoutCommand {

    private final UserLogin userLogin;

    @ShellMethod("User logout")
    public String logout() {
        String username = UserInfoUtil.getUsername();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.clearContext();
        }
        return String.format("Goodbye, %s!", username);
    }

}
