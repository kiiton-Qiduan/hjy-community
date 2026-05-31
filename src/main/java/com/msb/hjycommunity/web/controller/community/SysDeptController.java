package com.msb.hjycommunity.web.controller.community;

import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.system.domain.SysDept;
import com.msb.hjycommunity.system.domain.dto.SysDeptDto;
import com.msb.hjycommunity.system.service.SysDeptService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @GetMapping("/list")
    public BaseResponse findDeptList(SysDept sysDept){
        List<SysDeptDto> sysDeptDtos = sysDeptService.selectDeptList(sysDept);
        return BaseResponse.success(sysDeptDtos);
    }
}
