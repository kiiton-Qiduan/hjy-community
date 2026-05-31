package com.msb.hjycommunity.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.hjycommunity.system.domain.SysArea;

import java.util.List;

public interface SysAreaMapper extends BaseMapper<SysArea> {

    List<SysArea> selectAreaList();
}
