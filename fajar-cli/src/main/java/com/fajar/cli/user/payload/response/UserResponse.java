package com.fajar.cli.user.payload.response;

import com.fajar.cli.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@AllArgsConstructor(staticName = "valueOf")
public class UserResponse {

    String username;

    BigDecimal balance;

}
