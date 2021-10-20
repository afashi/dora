package com.dora.auth.feign.fallback;

import com.dora.auth.feign.User;
import com.dora.auth.feign.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * @author zhou
 * @date 2021/10/20
 */
@Slf4j
public class UserFeignClientFallback implements FallbackFactory<UserFeignClient> {

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User selectUserByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, cause);
                return new User();
            }

            @Override
            public User findByUsername(String username) {
                log.error("通过用户名查询用户异常:{}", username, cause);
                return new User();
            }
        };
    }
}
