package com.lbx.cloudgallery.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lbx.cloudgallery.model.dto.user.UserLoginRequest;
import com.lbx.cloudgallery.model.dto.user.UserQueryRequest;
import com.lbx.cloudgallery.model.dto.user.UserRegisterRequest;
import com.lbx.cloudgallery.model.entity.User;
import com.lbx.cloudgallery.model.vo.LoginUserVO;
import com.lbx.cloudgallery.model.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends IService<User> {
    /**
     * 用户注册
     */
    long userRegister(UserRegisterRequest userRegisterRequest);


    /**
     * 用户登录
     */
    LoginUserVO userLogin(UserLoginRequest userLoginRequest, HttpServletRequest request);

    /**
     * 获取当前登录用户
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取加密后的密码
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取脱敏后用户的信息
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏后用户的信息
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 获取脱敏后登录用户的信息
     */
    LoginUserVO getLoginUserVO(User user);

    /**
     * 用户登出
     */
    Boolean userLogout(HttpServletRequest request);

    /**
     * 获取查询条件
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);

    /**
     * 是否为管理员
     */
    Boolean isAdmin(User user);
}
