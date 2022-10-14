package com.fajar.cli.user.service;

import com.fajar.cli.user.payload.response.UserResponse;
import com.fajar.cli.user.payload.request.LoginRequest;

public interface UserLogin {

    public abstract UserResponse authenticate(LoginRequest loginRequest);
}
