package com.great.api.modules.sys.user.service.impl;

import com.great.api.modules.sys.user.entity.User;
import com.great.api.modules.sys.user.mapper.UserMapper;
import com.great.api.modules.sys.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author lins
 * @since 2020-04-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
