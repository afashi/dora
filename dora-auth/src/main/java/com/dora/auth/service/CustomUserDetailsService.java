package com.dora.auth.service;

import com.dora.auth.feign.User;
import com.dora.auth.feign.UserFeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * @author zhou
 * @date 2021/9/29
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    /**
     * 角色前缀
     */
    private static final String ROLE_PREFIX = "ROLE_";

    private final UserFeignClient userFeignClient;

    public CustomUserDetailsService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userFeignClient.selectUserByUsername(username);
        return new org.springframework.security.core.userdetails.User(
                "username",
                "password",
                new HashSet<>());
    }
}
