package com.great.api.modules.sys.login.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.great.api.modules.sys.user.entity.User;
import com.great.api.modules.sys.user.mapper.UserMapper;
import com.great.api.util.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息表(User)表控制层
 *
 * @author makejava
 * @since 2020-04-28 14:12:17
 */
@RestController
public class LoginController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/login")
    public AjaxResult login(User user) {
        // shiro登录
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return AjaxResult.success();
        } catch (UnknownAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return AjaxResult.error(e.getMessage());
        } catch (LockedAccountException e) {
            return AjaxResult.error(e.getMessage());
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return AjaxResult.error("认证失败！");
        }
    }

}