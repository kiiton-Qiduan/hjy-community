package com.msb.hjycommunity.web.controller.system;

import com.msb.hjycommunity.common.utils.ChainedMap;
import com.msb.hjycommunity.system.domain.vo.LoginBody;
import com.msb.hjycommunity.system.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService sysLoginService;

    @PostMapping("/login")
    public ChainedMap login(@RequestBody LoginBody loginBody){
        String token = sysLoginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(), loginBody.getUuid());
        return ChainedMap.create().set("token",token);
    }
}
