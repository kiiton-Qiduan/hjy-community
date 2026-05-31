package com.msb.hjycommunity.system.service;

import com.msb.hjycommunity.system.domain.SysArea;
import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.hjycommunity.system.domain.dto.SysAreaDto;

import java.util.List;

/**
* @author Qiduan
* @description 针对表【sys_area(区域表)】的数据库操作Service
* @createDate 2026-05-31 15:48:09
*/
public interface SysAreaService extends IService<SysArea> {

    List<SysAreaDto> queryAreaTree();

}
