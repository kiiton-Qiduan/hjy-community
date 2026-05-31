package com.msb.hjycommunity.system.mapper;

import com.msb.hjycommunity.system.domain.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msb.hjycommunity.system.domain.dto.SysDeptDto;

import java.util.List;

/**
* @author Qiduan
* @description 针对表【sys_dept(部门表)】的数据库操作Mapper
* @createDate 2026-05-31 22:17:25
* @Entity com.msb.hjycommunity.system.domain.SysDept
*/
public interface SysDeptMapper extends BaseMapper<SysDept> {
    public List<SysDeptDto> selectDeptList(SysDept sysDept);
}




