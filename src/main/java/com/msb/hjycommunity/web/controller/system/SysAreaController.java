package com.msb.hjycommunity.web.controller.system;

import com.msb.hjycommunity.common.core.controller.BaseController;
import com.msb.hjycommunity.common.core.domain.BaseResponse;
import com.msb.hjycommunity.system.domain.dto.SysAreaDto;
import com.msb.hjycommunity.system.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/area")
public class SysAreaController extends BaseController {

    @Autowired
    private SysAreaService sysAreaService;

    @GetMapping("/tree")
    public BaseResponse<List<SysAreaDto>> tree() {
        return BaseResponse.success(sysAreaService.queryAreaTree());
    }
}
