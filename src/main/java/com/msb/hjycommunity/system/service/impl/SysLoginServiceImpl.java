package com.msb.hjycommunity.system.service.impl;

import com.msb.hjycommunity.common.constant.Constants;
import com.msb.hjycommunity.common.core.exception.*;
import com.msb.hjycommunity.common.utils.RedisCache;
import com.msb.hjycommunity.system.domain.LoginUser;
import com.msb.hjycommunity.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class SysLoginServiceImpl implements SysLoginService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    /**
     * 带验证码登录
     * @param username
     * @param password
     * @param code
     * @param uuid
     * @return
     */
    @Override
    public String login(String username, String password, String code, String uuid) {

        //先验证验证码对不对
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha= redisCache.getCacheObject(key);
        redisCache.deleteObject(key);

        if(captcha == null || code == null || !code.equalsIgnoreCase(captcha)){
            throw new CaptchaNotMatchException();
        }

        //再验证密码对不对
        Authentication authentication = null;
        try{
            authentication = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (Exception e){
            throw new CustomException(400,"用户不存在/密码错误");
        }

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        return tokenService.createToken(loginUser);

    }
}
