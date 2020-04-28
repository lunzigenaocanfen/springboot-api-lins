package com.great.api.modules.sys.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.great.api.modules.sys.user.dao.UserDao;
import com.great.api.modules.sys.user.entity.User;
import com.great.api.modules.sys.user.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息表(User)表服务实现类
 *
 * @author makejava
 * @since 2020-04-28 14:12:17
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}