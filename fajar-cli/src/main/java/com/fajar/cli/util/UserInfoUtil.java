package com.fajar.cli.util;

import com.fajar.security.service.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUtil {

    private static SecurityContextImpl getContext() {

        return (SecurityContextImpl) SecurityContextHolder.getContext();
    }

    private static Optional<Object> getPrincipal() {

        if (null != getContext().getAuthentication()) {
            return Optional.of(getContext().getAuthentication().getPrincipal());
        }

        return Optional.empty();
    }

    private static Optional<UserDetailsImpl> getUserDetails() {

        Optional<Object> principal = getPrincipal();

        if (principal.isPresent()) {
            Object o = principal.get();
            if (o instanceof UserDetails) {
                return Optional.of(((UserDetailsImpl) o));
            }
        }

        return Optional.empty();
    }


    public static Long getUserId() {
        return getUserDetails()
            .map(UserDetailsImpl::getId)
            .orElse(0L);
    }

    public static String getUsername() {
        return getUserDetails()
            .map(UserDetailsImpl::getUsername)
            .orElse("");
    }
}