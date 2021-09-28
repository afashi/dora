package com.dora.common.swagger.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhou
 * @date 2021/9/28
 */
@Data
@Component
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

    /**
     * 是否开启swagger
     **/
    private Boolean enabled;
    /**
     * 标题
     **/
    private String title = "";
    /**
     * 描述
     **/
    private String description = "";
    /**
     * 版本
     **/
    private String version = "";

    /**
     * 联系方式
     */
    private Contact contact;

    @Data
    @NoArgsConstructor
    public static class Contact {

        /**
         * 联系人
         **/
        private String name;
        /**
         * 联系人url
         **/
        private String url;
        /**
         * 联系人email
         **/
        private String email;

    }

}

