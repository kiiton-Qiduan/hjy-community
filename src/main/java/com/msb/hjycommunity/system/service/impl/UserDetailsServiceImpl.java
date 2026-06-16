package com.msb.hjycommunity.system.service.impl;

import com.msb.hjycommunity.common.core.exception.BaseException;
import com.msb.hjycommunity.common.enums.UserStatus;
import com.msb.hjycommunity.system.domain.*;
import com.msb.hjycommunity.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserService.selectUserByUserName(username);

        //先判断用户查到没
        if(Objects.isNull(user)){
            log.info("登录用户：{}不存在！",username);
            throw new UsernameNotFoundException("登录用户" + username + "不存在");
        }
        else if(UserStatus.DELETED.getCode().equals(user.getDelFlag())){
            log.info("登录用户：{}已删除！",username);
            throw new BaseException("对不起，你的账号：" + username + "已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{}已停用！",username);
            throw new BaseException("对不起，你的账号：" + username + "已被停用");
        }

        return new LoginUser(user);

    }
}
