package com.msb.hjycommunity.web.controller;

import com.github.pagehelper.*;
import com.msb.hjycommunity.common.constant.HttpStatus;
import com.msb.hjycommunity.common.core.controller.BaseController;
import com.msb.hjycommunity.common.core.page.PageResult;
import com.msb.hjycommunity.common.utils.ServletUtils;
import com.msb.hjycommunity.community.domain.HjyCommunity;
import com.msb.hjycommunity.community.domain.dto.HjyCommunityDto;
import com.msb.hjycommunity.community.service.HjyCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class HjyCommunityController extends BaseController {

    @Autowired
    private HjyCommunityService hjyCommunityService;

    @GetMapping("/list")
    public PageResult list(HjyCommunity hjyCommunity){

        startPage();
        List<HjyCommunityDto> list = hjyCommunityService.queryList(hjyCommunity);

        return getData(list);
    }


}
