package com.fajar.cli.user.payload.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Value
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class LoginRequest {

    @NotBlank
    String username;

}
