package com.msb.hjycommunity.system.service;

import com.msb.hjycommunity.system.domain.SysDept;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.hjycommunity.system.domain.dto.SysDeptDto;

import java.util.List;

/**
* @author Qiduan
* @description 针对表【sys_dept(部门表)】的数据库操作Service
* @createDate 2026-05-31 22:17:25
*/
public interface SysDeptService extends IService<SysDept> {
    public List<SysDeptDto> selectDeptList(SysDept sysDept);
}
