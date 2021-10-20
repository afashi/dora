package com.dora.auth.feign;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author zhou
 * @date 2021/10/20
 */
@Getter
@Setter
@Accessors(chain = true)
public class User {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String nickname;

    private String headImgUrl;

    private String mobile;

    private String sex;

    private String enabled;

    private String type;

    private String deleted;
}
