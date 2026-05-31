package com.msb.hjycommunity.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msb.hjycommunity.system.domain.SysArea;
import com.msb.hjycommunity.system.domain.dto.SysAreaDto;
import com.msb.hjycommunity.system.service.SysAreaService;
import com.msb.hjycommunity.system.mapper.SysAreaMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Qiduan
* @description 针对表【sys_area(区域表)】的数据库操作Service实现
* @createDate 2026-05-31 15:48:09
*/
@Service
public class SysAreaServiceImpl extends ServiceImpl<SysAreaMapper, SysArea>
    implements SysAreaService{

    @Autowired
    private SysAreaMapper sysAreaMapper;

    @Override
    public List<SysAreaDto> queryAreaTree() {
        List<SysArea> areaList = sysAreaMapper.selectAreaList();
        List<SysAreaDto> dtoList = areaList.stream().map(this::toDto).collect(Collectors.toList());
        return buildTree(dtoList, 0);
    }

    private SysAreaDto toDto(SysArea sysArea) {
        SysAreaDto dto = new SysAreaDto();
        BeanUtils.copyProperties(sysArea, dto);
        return dto;
    }

    private List<SysAreaDto> buildTree(List<SysAreaDto> areaList, Integer parentCode) {
        return areaList.stream()
                .filter(area -> parentCode.equals(area.getParentid()))
                .peek(area -> area.setChildren(buildTree(areaList, area.getCode())))
                .collect(Collectors.toList());
    }
}




