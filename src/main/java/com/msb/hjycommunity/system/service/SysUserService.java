package com.msb.hjycommunity.system.service;

import com.msb.hjycommunity.system.domain.SysUser;
import org.springframework.stereotype.Service;


public interface SysUserService {

    public SysUser selectUserByUserName(String userName);
}
