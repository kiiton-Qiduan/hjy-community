package com.msb.hjycommunity.system.service;

import com.msb.hjycommunity.system.domain.LoginUser;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    public String createToken(LoginUser loginUser);

    /**
     * 缓存用户信息/刷新令牌有效期
     */
    public void refreshToken(LoginUser loginUser);

    /**
     * 获取用户信息
     * @param request
     * @return: com.msb.hjycommunity.system.domain.LoginUser
     */
    LoginUser getLoginUser(HttpServletRequest request);

    /**
     * 验证令牌的有效期,并且实现刷新缓存
     * @param loginUser
     */
    public void verifyToken(LoginUser loginUser);

    /**
     * 设置用户身份信息
     * @param loginUser
     */
    public void setLoginUser(LoginUser loginUser);

    /**
     * 删除用户
     * @param token
     */
    public void delLoginUser(String token);
}
