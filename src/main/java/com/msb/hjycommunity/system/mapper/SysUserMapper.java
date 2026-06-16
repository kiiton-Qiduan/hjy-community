package com.msb.hjycommunity.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.hjycommunity.system.domain.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser> {

    public SysUser selectUserByUserName(String userName);

}
