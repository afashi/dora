package com.dora.auth.feign;

import com.dora.auth.feign.fallback.UserFeignClientFallback;
import com.dora.common.core.constants.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhou
 * @date 2021/10/20
 */
@FeignClient(value = ServiceNameConstants.SYSTEM_SERVICE, fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
    /**
     * 查询用户
     *
     * @param username 用户名称
     * @return 用户数据对象
     */
    @GetMapping(value = "/users/name/{username}")
    User selectUserByUsername(@PathVariable("username") String username);

    /**
     * 查找用户
     *
     * @param username 用户名称
     * @return 用户数据对象
     */
    @GetMapping(value = "/users-anon/login", params = "username")
    User findByUsername(@RequestParam("username") String username);
}
