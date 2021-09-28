package com.dora.business.system.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dora.common.mybatis.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zhou
 * @since 2021-09-28
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value = "User对象", description = "")
public class User extends SuperEntity<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("头像地址")
    private String headImgUrl;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("是否启用")
    private String enabled;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("是否删除")
    @TableLogic
    private String deleted;


}
