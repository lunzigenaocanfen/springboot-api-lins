package com.great.api.modules.sys.user.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息表(User)表实体类
 *
 * @author makejava
 * @since 2020-04-28 14:12:17
 */
@Data
@TableName("sys_user")
public class User extends Model<User> {
    //用户ID
    @TableId
    private Long userId;
    //部门ID
    private Long deptId;
    //登录账号
    private String loginName;
    //用户昵称
    private String userName;
    //用户类型（00系统用户 01注册用户）
    private String userType;
    //用户邮箱
    private String email;
    //手机号码
    private String phonenumber;
    //用户性别（0男 1女 2未知）
    private String sex;
    //头像路径
    private String avatar;
    //密码
    private String password;
    //盐加密
    private String salt;
    //帐号状态（0正常 1停用）
    private String status;
    //删除标志（0代表存在 2代表删除）
    private String delFlag;
    //最后登陆IP
    private String loginIp;
    //最后登陆时间
    private Date loginDate;
    //创建者
    private String createBy;
    //创建时间
    private Date createTime;
    //更新者
    private String updateBy;
    //更新时间
    private Date updateTime;
    //备注
    private String remark;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    }