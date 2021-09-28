package com.dora.business.system.service.impl;

import com.dora.business.system.entity.User;
import com.dora.business.system.mapper.UserMapper;
import com.dora.business.system.service.UserService;
import com.dora.common.mybatis.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2021-09-28
 */
@Service
public class UserServiceImpl extends SuperServiceImpl<UserMapper, User> implements UserService {

}
