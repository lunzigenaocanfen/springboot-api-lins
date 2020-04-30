package com.great.api.common.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.great.api.modules.sys.user.entity.User;
import com.great.api.modules.sys.user.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        // 获取用户输入的用户名和密码
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        System.out.println("用户" + username + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User userParam = new User();
        userParam.setUsername(username);
        // 通过用户名到数据库查询用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!matches(user, password)) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (user.getStatus().equals("0")) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }


    public boolean matches(User user, String newPassword) {
        System.out.println(new Sha256Hash(newPassword, user.getSalt()).toHex());
        return user.getPassword().equals(new Sha256Hash(newPassword, user.getSalt()).toHex());
    }

}