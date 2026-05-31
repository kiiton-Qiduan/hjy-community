package com.msb.hjycommunity.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msb.hjycommunity.system.domain.SysDept;
import com.msb.hjycommunity.system.domain.dto.SysDeptDto;
import com.msb.hjycommunity.system.service.SysDeptService;
import com.msb.hjycommunity.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Qiduan
* @description 针对表【sys_dept(部门表)】的数据库操作Service实现
* @createDate 2026-05-31 22:17:25
*/
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept>
    implements SysDeptService{

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Override
    public List<SysDeptDto> selectDeptList(SysDept sysDept) {
        return sysDeptMapper.selectDeptList(sysDept);
    }
}




