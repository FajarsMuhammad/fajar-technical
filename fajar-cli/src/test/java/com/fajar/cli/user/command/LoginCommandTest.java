package com.fajar.cli.user.command;

import com.fajar.cli.user.payload.request.LoginRequest;
import com.fajar.cli.user.payload.response.UserResponse;
import com.fajar.cli.user.service.UserLogin;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.JLineShellComponent;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.when;

class LoginCommandTest {

    static JLineShellComponent shell;

    @InjectMocks
    private LoginCommand loginCommand;

    @Mock
    private UserLogin userLogin;

    @BeforeEach
    void startUp() throws InterruptedException {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void givenLoginwhenExecuteCommand() {
        String username = "user";
        LoginRequest loginRequest = new LoginRequest(username);
        UserResponse response = UserResponse
            .builder().username(username).balance(BigDecimal.ZERO).build();
        when(userLogin.authenticate(loginRequest)).thenReturn(response);

        String login = loginCommand.login(username);

        Assertions.assertEquals(String.format("Hello %s! Your balance is %s ",
            response.getUsername(), response.getBalance()), login);
    }

}
