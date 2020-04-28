package com.great.api.modules.sys.user.controller;

import com.great.api.modules.sys.user.entity.User;
import com.great.api.modules.sys.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2020-04-28 11:09:09
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

}